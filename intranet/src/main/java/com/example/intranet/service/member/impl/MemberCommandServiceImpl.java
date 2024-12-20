package com.example.intranet.service.member.impl;

import com.example.intranet.apiPayload.code.status.ErrorStatus;
import com.example.intranet.apiPayload.exception.handler.MemberHandler;
import com.example.intranet.converter.MemberConverter;
import com.example.intranet.domain.member.entity.Member;
import com.example.intranet.dto.member.MemberRequestDTO;
import com.example.intranet.dto.member.MemberResponseDTO;
import com.example.intranet.repository.MemberRepository;
import com.example.intranet.service.member.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    // 멤버 회원가입
    @Override
    public MemberResponseDTO.JoinResultDTO createMember(MemberRequestDTO.JoinDTO joinDTO) {
        Member member = MemberConverter.toMember(joinDTO);
        memberRepository.save(member);
        return MemberResponseDTO.JoinResultDTO.builder()
                .userId(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .build();

    }

    // 멤버 탈퇴
    @Override
    public void deleteMember(UUID memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> { throw new MemberHandler(ErrorStatus._NOT_FOUND_MEMBER); });
        memberRepository.delete(member);
    }

    // 멤버 정보 업데이트
    @Override
    public MemberResponseDTO.MemberResultDTO updateMember(MemberRequestDTO.UpdateMemberDTO updateMemberDTO, UUID memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> {
            throw new MemberHandler(ErrorStatus._NOT_FOUND_MEMBER);
        });
        member.update(updateMemberDTO);

        return MemberResponseDTO.MemberResultDTO.builder()
                .userId(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .phone(member.getPhone())
                .role(member.getRole())
                .position(member.getPosition())
                .build();
    }
}
