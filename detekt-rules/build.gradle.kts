dependencies {
    implementation(project(":detekt-api"))
    implementation(project(":detekt-metrics"))

    testImplementation(project(":detekt-api"))
    testImplementation(project(":detekt-core"))
    testImplementation(project(":detekt-parser"))
    testImplementation(project(":detekt-test"))
}
