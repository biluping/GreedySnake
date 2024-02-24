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
    implementation("cn.hutool:hutool-all:5.8.26")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to "org.myboy.MainKt"))
    }

    // 这里不加会报错依赖找不到
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
    val sourcesMain = sourceSets.main.get()
    sourcesMain.allSource.forEach { println("add from sources: ${it.name}") }
    from(sourcesMain.output)
}

kotlin {
    jvmToolchain(17)
}