import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.dsl.elhubProject
import no.elhub.devxp.build.configuration.pipeline.jobs.ansiblePublish


elhubProject(DEVXP, "devxp-ansible-collection-wsl") {

    val roles = listOf("adr", "ansible", "arcanist", "base", "docker", "git", "git_utils", "java", "kotlin", "linters", "molecule",
        "node", "python")

    pipeline {
        sequential {
//            parallel {
//                roles.forEach { moleculeTest(it) }
//            }
            ansiblePublish()
        }
    }
}
