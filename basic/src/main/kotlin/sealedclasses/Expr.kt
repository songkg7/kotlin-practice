package sealedclasses

sealed class Expr

class Num(val value: Int) : Expr()

class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        // NOTE: 'else' branch is redundant because 'when' covers all the cases when checking for sealed class
    }
}
