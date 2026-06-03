import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.dsl.elhubProject
import no.elhub.devxp.build.configuration.pipeline.jobs.ansiblePublish
import no.elhub.devxp.build.configuration.pipeline.jobs.makeVerify
import no.elhub.devxp.build.configuration.pipeline.jobs.moleculeTest


elhubProject(DEVXP, "devxp-ansible-collection-wsl") {

    val roles = listOf(
        "java"
        // "adr", "ansible", "arcanist", "base", "docker", "git", "git_utils", "kotlin", "linters", "molecule",
        // "node", "python"
    )

    pipeline {
        sequential {
            parallel {
                roles.forEach { moleculeTest(it) }
            }
            makeVerify {
                sonarScanSettings = {
                    sonarProjectModules = roles.map { "roles/$it" }
                    sonarProjectSources = "."
                    additionalParams = mutableListOf("-Dsonar.exclusions=roles/**/molecule/galaxy/**")
                }
                enablePublishMetrics = true
                publishMetricsSettings = {
                    skipCodeCoverage = true
                }
            }
            ansiblePublish()
        }
    }
}
