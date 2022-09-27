group = "no.elhub.${elhub_platform_name}
description = TODO("not implemented")

plugins {
    kotlin("jvm") version "1.7.10"
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(platform("no.elhub.${elhub_platform_name}:${elhub_platform_name}-bom:${TODO("version")}"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}
