package dsl.skills

sealed class Skill

data class HardSkill(val value: String) : Skill()

data class SoftSkill(val value: String) : Skill()
