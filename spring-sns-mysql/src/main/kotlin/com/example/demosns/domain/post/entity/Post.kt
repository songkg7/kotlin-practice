package com.example.demosns.domain.post.entity

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Post(
    @Id
    @GeneratedValue
    val id: Long? = null,

    val memberId: Long,

    val contents: String,

    val createAt: LocalDateTime = LocalDateTime.now(),

    val createDate: LocalDate = LocalDate.now(),
) {
}
