package lambdas

object MyFunction {

    operator fun invoke(s: String) = s.uppercase()

}