group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}
