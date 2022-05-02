package com.example.notebookwithkotlin.basic.sealedclasses

sealed class Color {
    data class Red(val r: Int, val g: Int, val b: Int) : Color()
    data class Orange(val r: Int, val g: Int, val b: Int) : Color()
    data class Yellow(val r: Int, val g: Int, val b: Int) : Color()
    data class Green(val r: Int, val g: Int, val b: Int) : Color()
    data class Blue(val r: Int, val g: Int, val b: Int) : Color()
    data class Indigo(val r: Int, val g: Int, val b: Int) : Color()
    data class Violet(val r: Int, val g: Int, val b: Int) : Color()
}