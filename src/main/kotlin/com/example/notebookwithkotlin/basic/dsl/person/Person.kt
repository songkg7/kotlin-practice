package com.example.notebookwithkotlin.basic.dsl.person

import com.example.notebookwithkotlin.basic.dsl.language.Languages
import com.example.notebookwithkotlin.basic.dsl.skills.Skills

data class Person(val name: String, val company: String, val skills: Skills, val languages: Languages) {
}