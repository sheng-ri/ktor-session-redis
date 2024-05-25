import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.11"
    `maven-publish`
}

group = "top.birthcat"
version = "1.0.0"

kotlin {
    compilerOptions.jvmTarget = JvmTarget.JVM_21
}

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

publishing {

}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-sessions-jvm")
    testImplementation("io.ktor:ktor-server-netty-jvm")
    testImplementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    testImplementation("io.lettuce:lettuce-core:6.3.2.RELEASE")
}