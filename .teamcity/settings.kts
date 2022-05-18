import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import no.elhub.common.build.configuration.AutoRelease
import no.elhub.common.build.configuration.CodeReview
import no.elhub.common.build.configuration.ProjectType.ANSIBLE
import no.elhub.common.build.configuration.SonarScan
import no.elhub.common.build.configuration.UnitTest

version = "2022.4"

project {

    val projectId = "no.elhub.devxp:ansible-collection-wsl"
    val projectType = ANSIBLE

    params {
        param("teamcity.ui.settings.readOnly", "true")
    }

    val sonarScanConfig = SonarScan.Config(
        vcsRoot = DslContext.settingsRoot,
        type = projectType,
        sonarId = projectId
    )

    // Release Build Chain
    listOf(sonarScan).forEach { buildType(it) }

}
