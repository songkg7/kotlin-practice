package basic.dsl

import basic.dsl.person.PersonBuilder

fun introduce(builder: PersonBuilder.() -> Unit) = PersonBuilder().apply(builder).build()