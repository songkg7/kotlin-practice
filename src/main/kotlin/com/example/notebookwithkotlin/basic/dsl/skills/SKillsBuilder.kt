package com.example.notebookwithkotlin.basic.dsl.skills

class SKillsBuilder {

    private val skills: MutableList<Skill> = mutableListOf()

    fun soft(value: String) {
        skills.add(SoftSkill(value))
    }

    fun hard(value: String) {
        skills.add(HardSkill(value))
    }

    fun build() = Skills(skills)

}