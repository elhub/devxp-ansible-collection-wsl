import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.dsl.elhubProject
import no.elhub.devxp.build.configuration.pipeline.jobs.ansiblePublish
import no.elhub.devxp.build.configuration.pipeline.jobs.makeVerify


elhubProject(DEVXP, "devxp-ansible-collection-wsl") {

    val roles = listOf(
        "adr", "ansible", "arcanist", "base", "docker", "git", "git_utils", "java", "kotlin", "linters", "molecule",
        "node", "python"
    )

    pipeline {
        sequential {
//            parallel {
//                roles.forEach { moleculeTest(it) }
//            }
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
