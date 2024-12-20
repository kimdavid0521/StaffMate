package com.example.intranet.service.member;

import com.example.intranet.domain.member.entity.Member;
import com.example.intranet.dto.member.MemberRequestDTO;
import com.example.intranet.dto.member.MemberResponseDTO;

import java.util.UUID;

public interface MemberCommandService {
    //command 는 객체를 변경하는 쓰기 insert, update, delete와 같이 db와 통신 후 응답값이 존재하지않는 요청들을 관리
    //분리 하는 이유: 읽기전용 트랙잭션을 사용하는 쿼리메서드와는 다르게 티랜잭션이 필요한 업데이트 또는 딜리트 인서트등의 데이터 변경 로직을 관리하기 위해 트랜잭셔널 어노테이션에 추가옵션을 붙이지않은채로 사용
    //query는 데이터 조회 기능을 가진 함수

    //멤버 회원가입
    MemberResponseDTO.JoinResultDTO createMember(MemberRequestDTO.JoinDTO joinDTO);

    // 멤버 탈퇴
    void deleteMember(UUID memberId);

    // 멤버 정보 업데이트
    MemberResponseDTO.MemberResultDTO updateMember(MemberRequestDTO.UpdateMemberDTO updateMemberDTO, UUID memberId);
}
