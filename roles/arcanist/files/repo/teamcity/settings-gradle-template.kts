import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group
import no.elhub.devxp.build.configuration.pipeline.jobs.gradleAutoRelease
import no.elhub.devxp.build.configuration.pipeline.jobs.gradleVerify


elhubProject(Group.TEST, "test-project-name") {

    phabricator {
        gradleVerify()
    }

    pipeline {
        sequential {
            val artifacts = gradleVerify()
            gradleAutoRelease(artifacts = listOf(artifacts))
        }
    }
}
