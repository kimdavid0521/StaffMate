package com.example.intranet.controller.member;

import com.example.intranet.apiPayload.BaseResponse;
import com.example.intranet.dto.member.MemberRequestDTO;
import com.example.intranet.dto.member.MemberResponseDTO;
import com.example.intranet.service.member.MemberCommandService;
import com.example.intranet.service.member.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    // 멤버 회원가입
    @PostMapping("/api/v1/members")
    public BaseResponse<MemberResponseDTO.JoinResultDTO> createMember(@RequestBody MemberRequestDTO.JoinDTO joinDTO) {
        return BaseResponse.onSuccess(memberCommandService.createMember(joinDTO));
    }

    // 멤버 조회
    @GetMapping("api/v1/members/{memberId}")
    public BaseResponse<MemberResponseDTO.MemberResultDTO> readMember(@PathVariable UUID memberId) {
        return BaseResponse.onSuccess(memberQueryService.readMember(memberId));
    }

    // 멤버 전체 조회
    @GetMapping("/api/v1/members/all")
    public BaseResponse<MemberResponseDTO.MemberResultListDTO> readAllMember() {
        return BaseResponse.onSuccess(memberQueryService.readAllMember());
    }

    // 멤버 탈퇴(멤버 삭제)
    @DeleteMapping("/api/v1/members/{memberId}")
    public BaseResponse<String> deleteMember(@PathVariable UUID memberId) {
        memberCommandService.deleteMember(memberId);
        return BaseResponse.onSuccess("탈퇴 되었습니다.");
    }


    // 유저 정보 업데이트
    @PatchMapping("/api/v1/members/{memberId}")
    public BaseResponse<MemberResponseDTO.MemberResultDTO> updateMember(@RequestBody MemberRequestDTO.UpdateMemberDTO updateMemberDTO,
                                                                        @PathVariable UUID memberId) {
        return BaseResponse.onSuccess(memberCommandService.updateMember(updateMemberDTO, memberId));
    }
}
