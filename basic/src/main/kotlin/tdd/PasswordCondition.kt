package tdd

interface PasswordCondition {
    fun isSatisfied(password: String): Boolean
}

class LengthCondition(private val length: Int): PasswordCondition {
    override fun isSatisfied(password: String) = password.length >= length
}

class UpperCaseCondition: PasswordCondition {
    override fun isSatisfied(password: String) = password.any { it.isUpperCase() }
}

class NumberCondition: PasswordCondition {
    override fun isSatisfied(password: String) = password.any { it.isDigit() }
}
