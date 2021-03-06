package list

import org.junit.jupiter.api.Test

internal class SystemUserTest {

    @Test
    internal fun list() {
        val systemUser = collections.list.SystemUser()

        systemUser.addSystemUser(4)
        println("Tot sudoers: ${systemUser.getSysSudoers().size}")
        systemUser.getSysSudoers().forEach { println("Some useful info on user $it") }
    }
}