rootProject.name = "${elhub_module_name}"

pluginManagement {
    repositories {
        maven(url = "https://jfrog.elhub.cloud:443/artifactory/elhub-plugins")
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://jfrog.elhub.cloud:443/artifactory/elhub-mvn")
    }
    versionCatalogs {
        create("libs") {
            from("no.elhub.devxp:devxp-version-catalog:0.5.1") // TODO: REPLACE WITH YOUR CATALOG (if you have one)
        }
    }
}
