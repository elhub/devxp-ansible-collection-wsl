import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import no.elhub.devxp.build.configuration.Assemble
import no.elhub.devxp.build.configuration.AutoRelease
import no.elhub.devxp.build.configuration.CodeReview
import no.elhub.devxp.build.configuration.ProjectType
import no.elhub.devxp.build.configuration.SonarScan
import no.elhub.devxp.build.configuration.UnitTest

version = "2022.10"

project {

    params {
        param("teamcity.ui.settings.readOnly", "true")
    }

    val projectName = "${elhub_module_name}"
    val projectId = projectId(PlatformName.${elhub_platform_name_upper}, projectName)
    val projectType = ProjectType.MAVEN
    val artifactoryRepository = "elhub-mvn-release-local"

    val sonarScanConfig = SonarScan.Config(
        vcsRoot = DslContext.settingsRoot,
        type = projectType,
        sonarId = projectId
    )

    buildType(
        CodeReview(
            CodeReview.Config(
                vcsRoot = DslContext.settingsRoot,
                type = projectType,
                sonarScanConfig = sonarScanConfig,
            )
        )
    )

    val unitTest = UnitTest(
        UnitTest.Config(
            vcsRoot = DslContext.settingsRoot,
            type = projectType
        )
    )

    val sonarScan = SonarScan(sonarScanConfig) {
        dependencies {
            snapshot(unitTest) { }
        }
    }

    val assemble = Assemble(
        Assemble.Config(
            vcsRoot = DslContext.settingsRoot,
            type = projectType
        )
    ) {
        dependencies {
            snapshot(sonarScan) { }
        }
    }

    val autoRelease = AutoRelease(
        AutoRelease.Config(
            vcsRoot = DslContext.settingsRoot,
            type = projectType,
        )
    ) {
        dependencies {
            snapshot(assemble) { }
        }
    }

    listOf(unitTest, sonarScan, assemble, autoRelease).forEach { buildType(it) }
}
