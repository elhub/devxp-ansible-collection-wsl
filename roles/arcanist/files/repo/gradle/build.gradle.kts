plugins {
    id("no.elhub.devxp.kotlin-library") version "0.0.15"
}

group = "no.elhub.${elhub_platform_name}
description = TODO("not implemented")

repositories {
    maven("https://jfrog.elhub.cloud/artifactory/elhub-mvn")
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(libs.kotlin.stdlib.jdk8)
    testImplementation(libs.test.kotest.runner.junit5)
}
