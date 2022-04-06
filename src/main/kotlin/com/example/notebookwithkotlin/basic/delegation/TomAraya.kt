package com.example.notebookwithkotlin.basic.delegation

class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)