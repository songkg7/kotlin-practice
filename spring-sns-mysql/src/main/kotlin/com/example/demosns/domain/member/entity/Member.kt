package com.example.demosns.domain.member.entity

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
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

    @Column(unique = true)
    var email: String,

    val createAt: LocalDateTime = LocalDateTime.now(),
) {
    fun changeNickname(nickname: String) {
        this.nickname = nickname
    }
}
