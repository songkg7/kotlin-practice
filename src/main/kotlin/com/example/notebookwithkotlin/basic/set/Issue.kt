package com.example.notebookwithkotlin.basic.set

class Issue {

    val openIssues: MutableSet<String> = mutableSetOf("veil", "continue", "pinch")

    fun addIssue(keyword: String): Boolean {
        return openIssues.add(keyword)
    }

    fun getStatusLog(isAdded: Boolean): String {
        return if (isAdded) "registered correctly." else "marked as duplicate and rejected."
    }

}