plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":ktorm-kapt-annotations"))
    implementation(group = "com.bennyhuo.aptutils", name = "aptutils", version = "1.7.1")
    implementation(group = "com.squareup", name = "javapoet", version = "1.9.0")
    implementation(group = "com.squareup", name = "kotlinpoet", version = "1.8.0")
    compileOnly(files(org.gradle.internal.jvm.Jvm.current().toolsJar))
}
