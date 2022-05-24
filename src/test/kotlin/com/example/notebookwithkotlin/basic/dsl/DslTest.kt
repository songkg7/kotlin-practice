package com.example.notebookwithkotlin.basic.dsl

import com.example.notebookwithkotlin.basic.dsl.language.Language
import com.example.notebookwithkotlin.basic.dsl.skills.HardSkill
import com.example.notebookwithkotlin.basic.dsl.skills.SoftSkill
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DslTest {

    @Test
    internal fun dsl() {
        val resume = introduce {
            name("송경근")
            company("testCompany")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
            languages {
                "Korean" level 5
                "English" level 3
                "Japanese" level 4
            }
        }

        resume.name shouldBe "송경근"
        resume.company shouldBe "testCompany"
        resume.skills.values shouldContainExactly listOf(
            SoftSkill("A passion for problem solving"),
            SoftSkill("Good communication skills"),
            HardSkill("Kotlin")
        )
        resume.languages.values shouldContainExactly listOf(
            Language("Korean", 5),
            Language("English", 3),
            Language("Japanese", 4)
        )
    }
}