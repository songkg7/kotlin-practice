package com.example.demosns.domain.follow.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Follow(
    @Id
    @GeneratedValue
    val id: Long? = null,

    val toMemberId: Long,

    val fromMemberId: Long,

    val createAt: LocalDateTime = LocalDateTime.now(),
)
