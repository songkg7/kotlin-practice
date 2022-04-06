package com.example.notebookwithkotlin.basic.delegation

class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)