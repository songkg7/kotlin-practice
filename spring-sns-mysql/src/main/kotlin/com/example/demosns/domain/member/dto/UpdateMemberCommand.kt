package com.example.demosns.domain.member.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateMemberCommand(
    @JsonProperty("nickname")
    val nickname: String,
)
