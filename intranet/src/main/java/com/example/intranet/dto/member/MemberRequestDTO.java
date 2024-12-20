package com.example.intranet.dto.member;

import com.example.intranet.domain.member.constants.Gender;
import com.example.intranet.domain.member.constants.Position;
import com.example.intranet.domain.member.constants.Role;
import lombok.Getter;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO {
        private String username;
        private String email;
        private String password;
        private String phone;
        private Role role;
        private Gender gender;
        private Position position;
    }

    // 멤버 정보 업데이트
    @Getter
    public static class UpdateMemberDTO {
        private String username;
        private String email;
        private String phone;
    }
}
