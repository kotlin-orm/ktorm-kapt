include("ktorm-kapt-annotations")
include("ktorm-kapt-compiler")
include("ktorm-kapt-demo")

rootProject.name = "ktorm-kapt"
rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
}
