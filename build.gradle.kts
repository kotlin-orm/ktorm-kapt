plugins {
    kotlin("jvm") version "1.5.10"
}

allprojects {
    group = "org.ktorm"
    version = "0.0.1"

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.6"
        kotlinOptions.allWarningsAsErrors = true
        kotlinOptions.freeCompilerArgs += "-Xexplicit-api=strict"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }

    repositories {
        mavenCentral()
    }

    dependencies {
    }
}
