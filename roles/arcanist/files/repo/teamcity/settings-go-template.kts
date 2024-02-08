import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group
import no.elhub.devxp.build.configuration.pipeline.jobs.genericAutoRelease
import no.elhub.devxp.build.configuration.pipeline.jobs.goVerify


elhubProject(Group.TEST, "test-project-name") {

    phabricator {
        goVerify()
    }

    pipeline {
        sequential {
            goVerify()
            genericAutoRelease() // goAutoRelease is in development. This only pushes tags to the repository.
        }
    }
}
