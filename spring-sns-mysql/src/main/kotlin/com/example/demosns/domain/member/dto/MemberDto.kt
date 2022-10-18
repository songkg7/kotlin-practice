package com.example.demosns.domain.member.dto

import com.example.demosns.domain.member.entity.Member
import java.time.LocalDate

data class MemberDto(
    val id: Long,
    val nickname: String,
    val birthday: LocalDate,
    val email: String,
) {
    companion object {
        fun of(member: Member): MemberDto = MemberDto(
            id = member.id!!,
            nickname = member.nickname,
            birthday = member.birthday,
            email = member.email,
        )
    }
}
