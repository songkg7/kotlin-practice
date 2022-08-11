plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.spring") version "1.7.0"
}

java.sourceCompatibility = JavaVersion.VERSION_11

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.2")
        testImplementation("org.assertj:assertj-core:3.23.1")
        testImplementation("io.kotest:kotest-runner-junit5:5.3.1")
        testImplementation("io.kotest:kotest-assertions-core:5.3.1")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
