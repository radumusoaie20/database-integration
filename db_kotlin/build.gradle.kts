plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.tut.db"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation("mysql","mysql-connector-java",  "8.0.15")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}