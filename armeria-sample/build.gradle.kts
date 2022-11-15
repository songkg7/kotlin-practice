plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.example"
version = "unspecified"
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.linecorp.armeria:armeria:1.20.2")
    implementation("com.linecorp.armeria:armeria-kotlin:1.20.2")
    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("io.github.microutils:kotlin-logging:3.0.4")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.5.4")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-kotlin:0.4.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

// parameter 생략 적용 안됨
tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}

// parameter 생략 적용 안됨
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        javaParameters = true
    }
}
