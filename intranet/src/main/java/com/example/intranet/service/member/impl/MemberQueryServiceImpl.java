package com.example.intranet.service.member.impl;

import com.example.intranet.apiPayload.code.status.ErrorStatus;
import com.example.intranet.apiPayload.exception.handler.MemberHandler;
import com.example.intranet.domain.member.entity.Member;
import com.example.intranet.dto.member.MemberResponseDTO;
import com.example.intranet.repository.MemberRepository;
import com.example.intranet.service.member.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    // 멤버 단건 조회
    @Override
    public MemberResponseDTO.MemberResultDTO readMember(UUID memberId) {
        Member member =  memberRepository.findById(memberId).orElseThrow(() -> {
            throw new MemberHandler(ErrorStatus._NOT_FOUND_MEMBER);
        });
        return MemberResponseDTO.MemberResultDTO.builder()
                .userId(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .phone(member.getPhone())
                .role(member.getRole())
                .position(member.getPosition())
                .build();
    }

    // 멤버 리스트 전체 조회
    @Override
    public MemberResponseDTO.MemberResultListDTO readAllMember() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberResponseDTO.MemberResultDTO> memberResultDTOList = memberList.stream()
                .map(members -> MemberResponseDTO.MemberResultDTO.builder()
                        .userId(members.getId())
                        .username(members.getUsername())
                        .email(members.getEmail())
                        .phone(members.getPhone())
                        .role(members.getRole())
                        .position(members.getPosition())
                        .build())
                .collect(Collectors.toList());

        return MemberResponseDTO.MemberResultListDTO.builder()
                .memberResultDTOList(memberResultDTOList)
                .build();
    }
}
