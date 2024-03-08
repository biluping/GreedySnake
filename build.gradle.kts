plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

group = "org.myboy"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("cn.hutool:hutool-all:5.8.26")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}

tasks.test {
    useJUnitPlatform()
}


tasks.jar {

    // 打包时发现文件重复自动排除，防止报错
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // 添加主类
    manifest {
        attributes(mapOf("Main-Class" to "org.myboy.MainKt"))
    }

//    // 添加源文件
//    from(sourceSets.main.get().output)

    // 添加依赖
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}

kotlin {
    jvmToolchain(17)
}