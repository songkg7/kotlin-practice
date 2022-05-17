package com.example.notebookwithkotlin.designpattern.proxy

interface Rider {
    fun delivery(): String
    fun getPersonal(level: Int): String?
}