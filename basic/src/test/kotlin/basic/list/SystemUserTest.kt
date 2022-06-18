package basic.list

import basic.collections.list.SystemUser
import org.junit.jupiter.api.Test

internal class SystemUserTest {

    @Test
    internal fun list() {
        val systemUser = SystemUser()

        systemUser.addSystemUser(4)
        println("Tot sudoers: ${systemUser.getSysSudoers().size}")
        systemUser.getSysSudoers().forEach { println("Some useful info on user $it") }
    }
}