package set

import org.junit.jupiter.api.Test

internal class IssueTest {

    @Test
    internal fun set() {
        val issue = collections.set.Issue()

        val newIssue = "veil2"
        val anIssueAlreadyIn = "pinch"

        println("Issue $newIssue ${issue.getStatusLog(issue.addIssue(newIssue))}")
        println("Issue $anIssueAlreadyIn ${issue.getStatusLog(issue.addIssue(anIssueAlreadyIn))}")
    }

    @Test
    internal fun with() {
        with(collections.set.Issue()) {
            val newIssue = "veil2"
            val anIssueAlreadyIn = "pinch"

            println("Issue $newIssue ${getStatusLog(addIssue(newIssue))}")
            println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")
        }
    }
}