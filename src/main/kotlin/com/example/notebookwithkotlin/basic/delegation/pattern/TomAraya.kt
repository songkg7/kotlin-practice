package com.example.notebookwithkotlin.basic.delegation.pattern

class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)