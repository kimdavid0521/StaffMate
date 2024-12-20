package com.example.intranet.service.member;

import com.example.intranet.dto.member.MemberResponseDTO;

import java.util.UUID;

public interface MemberQueryService {
    //query는 데이터 조회 기능을 가진 함수

    // 멤버 단건 조회
    MemberResponseDTO.MemberResultDTO readMember(UUID memberId);

    // 멤버 리스트 전체 리스트 조회
    MemberResponseDTO.MemberResultListDTO readAllMember();
}
