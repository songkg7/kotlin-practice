plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.example"
version = "unspecified"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.linecorp.armeria:armeria:1.20.2")
    implementation("com.linecorp.armeria:armeria-kotlin:1.20.2")
    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("io.github.microutils:kotlin-logging:3.0.4")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
