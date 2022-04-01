package com.example.notebookwithkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotebookWithKotlinApplication

fun main(args: Array<String>) {
	runApplication<NotebookWithKotlinApplication>(*args)
}
