package com.example.intranet.domain.mapping.entity;

import com.example.intranet.domain.attendance.entity.Attendance;
import com.example.intranet.domain.member.entity.Member;
import jakarta.persistence.*;

@Entity
public class MemberAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendance_id")
    private Attendance attendance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
