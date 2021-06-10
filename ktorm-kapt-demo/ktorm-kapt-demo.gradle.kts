plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    api(project(":ktorm-kapt-annotations"))
    kapt(project(":ktorm-kapt-compiler"))
}
