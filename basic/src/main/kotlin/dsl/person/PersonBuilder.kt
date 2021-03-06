package dsl.person

import dsl.language.LanguageBuilder
import dsl.language.Languages
import dsl.skills.SKillsBuilder
import dsl.skills.Skills

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