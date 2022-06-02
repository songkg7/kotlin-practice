package com.example.notebookwithkotlin.basic.lambdas

object MyFunction {

    operator fun invoke(s: String) = s.uppercase()

}