package com.example.notebookwithkotlin.basic.set

import com.example.notebookwithkotlin.basic.collections.set.Issue
import org.junit.jupiter.api.Test

internal class IssueTest {

    @Test
    internal fun set() {
        val issue = Issue()

        val newIssue = "veil2"
        val anIssueAlreadyIn = "pinch"

        println("Issue $newIssue ${issue.getStatusLog(issue.addIssue(newIssue))}")
        println("Issue $anIssueAlreadyIn ${issue.getStatusLog(issue.addIssue(anIssueAlreadyIn))}")
    }

    @Test
    internal fun with() {
        with(Issue()) {
            val newIssue = "veil2"
            val anIssueAlreadyIn = "pinch"

            println("Issue $newIssue ${getStatusLog(addIssue(newIssue))}")
            println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")
        }
    }
}