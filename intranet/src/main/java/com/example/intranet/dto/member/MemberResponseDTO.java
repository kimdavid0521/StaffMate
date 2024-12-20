package com.example.intranet.dto.member;

import com.example.intranet.domain.member.constants.Position;
import com.example.intranet.domain.member.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

public class MemberResponseDTO {

    // 회원가입시 응답
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        private UUID userId;
        private String username;
        private String email;
    }

    //회원 단건 조회
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberResultDTO {
        private UUID userId;
        private String username;
        private String email;
        private String phone;
        private Role role;
        private Position position;
    }

    // 회원 리스트 전체 조회
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberResultListDTO {
        List<MemberResultDTO> memberResultDTOList;
    }
}
