package com.example.demosns.domain.member.dto

import com.example.demosns.domain.member.entity.Member
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class RegistMemberCommand(
    @Size(max = 10)
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
