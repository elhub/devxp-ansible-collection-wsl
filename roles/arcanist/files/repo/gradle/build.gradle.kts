plugins {
    id("no.elhub.devxp.kotlin-library") version "0.1.6"
}

group = "no.elhub.${elhub_platform_name}
description = TODO("not implemented")

repositories {
    maven("https://jfrog.elhub.cloud/artifactory/elhub-mvn")
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    testImplementation(libs.test.kotest.runner.junit5)
}
