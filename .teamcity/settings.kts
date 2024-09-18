import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.DslContext
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.toId
import no.elhub.devxp.build.configuration.pipeline.ElhubProject.Companion.elhubProject
import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.jobs.*


elhubProject(DEVXP, "devxp-ansible-collection-wsl") {

    val roles = listOf(
        "adr", "ansible", "base", "docker", "git", "git_utils", "java", "kotlin", "linters", "molecule",
        "node", "python"
    )

    codeReview {
        sequential {
            buildType(MegaLinter())
            ansibleSonarScan()
            parallel {
                roles.forEach { moleculeTest(it) }
            }
        }
    }

    pipeline {
        sequential {
            buildType(MegaLinter())
            parallel {
                roles.forEach { moleculeTest(it) }
            }
            ansibleAutoRelease()
        }
    }
}

class MegaLinter(lintAll: Boolean = false) : BuildType({
    id("LintProject".toId())
    name = "🧹 Lint Project"

    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }

    steps {
        script {
            name = "Run Megalinter"
            scriptContent = """
                #!/bin/bash
                . ~/.nvm/nvm.sh
                gh dxp lint \
                --image "%env.docker_repository%/oxsecurity/megalinter-cupcake:v8" \
                --proxy "%env.http_proxy%" ${if (lintAll) " --all" else ""}
            """.trimIndent()
        }
    }
})
