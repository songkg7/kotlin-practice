package com.example.springdataelasticsearch.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.LocalDateTime
import kotlin.random.Random

@Document(indexName = "users")
class User {

    @Id
    var id: Long = Random.nextLong()

    var name: String? = null

    var age: Int? = null

    var email: String? = null

    @Field(type = FieldType.Date, format = [], pattern = ["yyyy-MM-dd'T'HH:mm:ss'Z'"])
    var created: LocalDateTime = LocalDateTime.now()

}
