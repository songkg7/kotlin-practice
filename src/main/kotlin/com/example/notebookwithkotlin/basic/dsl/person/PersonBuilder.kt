package com.example.notebookwithkotlin.basic.dsl.person

import com.example.notebookwithkotlin.basic.dsl.language.LanguageBuilder
import com.example.notebookwithkotlin.basic.dsl.language.Languages
import com.example.notebookwithkotlin.basic.dsl.skills.SKillsBuilder
import com.example.notebookwithkotlin.basic.dsl.skills.Skills

class PersonBuilder {

    lateinit var name: String
    lateinit var company: String
    lateinit var skills: Skills
    lateinit var languages: Languages

    fun name(value: String) {
        name = value
    }

    fun company(value: String) {
        company = value
    }

    fun skills(builder: SKillsBuilder.() -> Unit) {
        skills = SKillsBuilder().apply(builder).build()
    }

    fun languages(builder: LanguageBuilder.() -> Unit) {
        languages = LanguageBuilder().apply(builder).build()
    }

    fun build() = Person(name, company, skills, languages)
}