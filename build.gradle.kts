plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.myboy"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to "org.myboy.MainKt"))
    }
}

kotlin {
    jvmToolchain(17)
}