plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.7.0"
    kotlin("plugin.jpa") version "1.7.0"
    id ("org.jetbrains.kotlin.plugin.allopen")
    id ("org.jetbrains.kotlin.plugin.noarg") version "1.7.0"
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}