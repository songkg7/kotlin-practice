plugins {
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    kotlin("plugin.jpa") version "1.7.20"
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

val asciidoctorExtentions by configurations.creating

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

group = "org.example"

version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

tasks.asciidoctor {
    inputs.dir(snippetsDir)
    dependsOn(tasks.test)
    configurations(asciidoctorExtentions.name)
    baseDirFollowsSourceDir()
    doLast {
        copy {
            from(outputDir)
            into("src/main/resources/static/docs")
        }
    }
    doFirst { // 2
        delete {
            file("src/main/resources/static/docs")
        }
    }
}

tasks.build {
    dependsOn(tasks.asciidoctor)
}

dependencies {
    asciidoctorExtentions("org.springframework.restdocs:spring-restdocs-asciidoctor")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("mysql:mysql-connector-java")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.3")
    testImplementation("io.kotest:kotest-assertions-core:5.5.3")
    testImplementation("io.kotest:kotest-extensions-spring:4.4.3")
    testImplementation("io.mockk:mockk:1.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-kotlin:0.4.2")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:0.4.2")
}
val snippetsDir by extra { file("build/generated-snippets") }

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    outputs.dir(snippetsDir)
}
