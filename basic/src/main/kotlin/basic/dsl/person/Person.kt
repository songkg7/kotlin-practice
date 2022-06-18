package basic.dsl.person

import basic.dsl.language.Languages
import basic.dsl.skills.Skills

data class Person(val name: String, val company: String, val skills: Skills, val languages: Languages) {
}