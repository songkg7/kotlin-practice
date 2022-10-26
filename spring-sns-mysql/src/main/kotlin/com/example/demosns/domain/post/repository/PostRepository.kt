package com.example.demosns.domain.post.repository

import com.example.demosns.domain.post.dto.DailyPostCount
import com.example.demosns.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface PostRepository : JpaRepository<Post, Long> {

    @Query("select new com.example.demosns.domain.post.dto.DailyPostCount(p.memberId, p.createDate, count(p))" +
            " from Post p" +
            " where p.memberId = :memberId" +
            " and p.createDate between :startDate and :endDate" +
            " group by p.memberId, p.createDate")
    fun findDailyCounts(memberId: Long, startDate: LocalDate, endDate: LocalDate): List<DailyPostCount>

}



