package com.example.demosns.domain.member.dto

import com.example.demosns.domain.member.entity.Member
import java.time.LocalDate
import javax.validation.constraints.Email

data class MemberDto(
    val nickname: String,
    val birthday: LocalDate,

    @Email
    val email: String,
) {
    fun toEntity() = Member(
        nickname = nickname,
        birthday = birthday,
        email = email,
    )
}
