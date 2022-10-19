package com.example.demosns.domain.member.dto

import com.example.demosns.domain.member.entity.Member
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class CreateMemberCommand(
    @Size(max = 10)
    @JsonProperty("nickname")
    val nickname: String,

    @JsonProperty("birthday")
    val birthday: LocalDate,

    @Email
    @JsonProperty("email")
    val email: String,
) {
    fun toEntity() = Member(
        nickname = nickname,
        birthday = birthday,
        email = email,
    )
}
