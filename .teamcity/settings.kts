import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.jobs.ansibleAutoRelease
import no.elhub.devxp.build.configuration.pipeline.jobs.moleculeTest


elhubProject(DEVXP, "devxp-ansible-collection-wsl") {

    val roles = listOf("adr", "ansible", "arcanist", "base", "docker", "git", "git_utils", "java", "kotlin", "linters", "molecule",
        "node", "python")

    pipeline {
        sequential {
//            parallel {
//                roles.forEach { moleculeTest(it) }
//            }
            ansibleAutoRelease()
        }
    }
}
