package com.example.notebookwithkotlin.basic.delegation.pattern

class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)