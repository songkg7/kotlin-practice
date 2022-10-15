package com.example.demosns.domain.member.repository

import com.example.demosns.domain.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>
