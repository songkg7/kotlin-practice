package com.example.springdataelasticsearch.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.time.LocalDateTime

@Document(indexName = "users")
class User {

    @Id
    var id: Long? = null

    var name: String? = null

    var age: Int? = null

    var email: String? = null

    var created: LocalDateTime? = null

}
