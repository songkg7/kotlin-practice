package dsl

import dsl.person.PersonBuilder

fun introduce(builder: PersonBuilder.() -> Unit) = PersonBuilder().apply(builder).build()