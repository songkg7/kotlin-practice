package com.example.demosns.domain.follow.repository

import com.example.demosns.domain.follow.entity.Follow
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, Long> {

    fun findAllByFromMemberId(fromMemberId: Long): List<Follow>

}
