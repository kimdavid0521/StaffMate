package com.example.intranet.converter;

import com.example.intranet.domain.member.entity.Member;
import com.example.intranet.dto.member.MemberRequestDTO;
import com.example.intranet.dto.member.MemberResponseDTO;

public class MemberConverter {

    // 멤버 객체 생성 컨버터
    public static Member toMember(MemberRequestDTO.JoinDTO joinDTO) {
        return Member.builder()
                .username(joinDTO.getUsername())
                .email(joinDTO.getEmail())
                .password(joinDTO.getPassword())
                .phone(joinDTO.getPhone())
                .role(joinDTO.getRole())
                .gender(joinDTO.getGender())
                .position(joinDTO.getPosition())
                .build();
    }

    // 멤버 회원가입 응답 컨버터
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .userId(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .build();
    }




}
