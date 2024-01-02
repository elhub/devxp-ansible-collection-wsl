import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.jobs.ansibleAutoRelease
import no.elhub.devxp.build.configuration.pipeline.jobs.ansibleSonarScan
import no.elhub.devxp.build.configuration.pipeline.jobs.moleculeTest

elhubProject(DEVXP, "ansible-collection-wsl") {

    val roles = listOf("adr", "ansible", "arcanist", "base", "docker", "git", "gitutils", "java", "kotlin", "linters", "molecule",
        "node", "python")

    phabricator {
        sequential {
            ansibleSonarScan()
            roles.forEach { moleculeTest(it) }
        }
    }

    pipeline {
        sequential {
            roles.forEach { moleculeTest(it) }
            ansibleAutoRelease()
        }
    }
}
