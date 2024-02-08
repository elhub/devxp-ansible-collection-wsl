import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group
import no.elhub.devxp.build.configuration.pipeline.jobs.npmAutoRelease
import no.elhub.devxp.build.configuration.pipeline.jobs.npmVerify


elhubProject(Group.TEST, "test-project-name") {

    phabricator {
        npmVerify()
    }

    pipeline {
        sequential {
            val artifacts = npmVerify()
            npmAutoRelease(artifacts = listOf(artifacts))
        }
    }
}
