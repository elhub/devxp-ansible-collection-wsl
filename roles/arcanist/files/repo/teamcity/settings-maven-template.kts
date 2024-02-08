import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group
import no.elhub.devxp.build.configuration.pipeline.jobs.mavenAutoRelease
import no.elhub.devxp.build.configuration.pipeline.jobs.mavenVerify


elhubProject(Group.TEST, "test-project-name") {

    phabricator {
        mavenVerify()
    }

    pipeline {
        sequential {
            val artifacts = mavenVerify()
            mavenAutoRelease(artifacts = listOf(artifacts))
        }
    }
}
