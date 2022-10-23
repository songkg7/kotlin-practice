package com.example.demosns.domain.member.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class MemberNicknameHistory(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(updatable = false)
    val memberId: Long,

    @Column(updatable = false)
    val nickname: String,

    @Column(updatable = false)
    val createdAt: LocalDateTime,
)
