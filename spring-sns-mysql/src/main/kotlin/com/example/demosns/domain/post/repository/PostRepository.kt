package com.example.demosns.domain.post.repository

import com.example.demosns.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>



