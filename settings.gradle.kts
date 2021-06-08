include("ktorm-kapt-annotations")

rootProject.name = "ktorm-kapt"
rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
}
