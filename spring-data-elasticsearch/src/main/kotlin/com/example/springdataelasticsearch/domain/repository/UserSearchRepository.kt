package com.example.springdataelasticsearch.domain.repository

import com.example.springdataelasticsearch.domain.User
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface UserSearchRepository : ElasticsearchRepository<User, Long> {


}
