package com.example.demosns.domain.member.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue
    val id: Long? = null,
    var nickname: String,
    val birthday: LocalDate,
    var email: String,
    val createAt: LocalDate = LocalDate.now(),
)