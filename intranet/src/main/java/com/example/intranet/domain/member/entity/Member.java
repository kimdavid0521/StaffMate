package com.example.intranet.domain.member.entity;

import com.example.intranet.domain.common.BaseEntity;
import com.example.intranet.domain.mapping.entity.MemberAttendance;
import com.example.intranet.domain.mapping.entity.MemberEvent;
import com.example.intranet.domain.member.constants.Gender;
import com.example.intranet.domain.member.constants.Position;
import com.example.intranet.domain.member.constants.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 40)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 60)
    private Position position;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAttendance> memberAttendances = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberEvent> memberEvents = new ArrayList<>();

}

