package tdd

class PasswordStrengthMeter(
    private val conditions: List<PasswordCondition> = listOf(
        LengthCondition(8),
        UpperCaseCondition(),
        NumberCondition()
    ),
) {

    fun test(password: String) =
        when (conditions.count { it.isSatisfied(password) }) {
            3 -> PasswordStrength.STRONG
            2 -> PasswordStrength.NORMAL
            else -> PasswordStrength.WEAK
        }
}

enum class PasswordStrength {
    STRONG, NORMAL, WEAK
}
