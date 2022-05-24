package com.example.notebookwithkotlin.basic.dsl

import com.example.notebookwithkotlin.basic.dsl.person.PersonBuilder

fun introduce(builder: PersonBuilder.() -> Unit) = PersonBuilder().apply(builder).build()