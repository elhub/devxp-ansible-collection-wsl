import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.ReuseBuilds
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import no.elhub.devxp.build.configuration.pipeline.constants.AgentScope
import no.elhub.devxp.build.configuration.pipeline.constants.Group.DEVXP
import no.elhub.devxp.build.configuration.pipeline.dsl.elhubProject
import no.elhub.devxp.build.configuration.pipeline.extensions.triggerOnVcsChange
import no.elhub.devxp.build.configuration.pipeline.jobs.customJob
import no.elhub.devxp.build.configuration.pipeline.jobs.moleculeTest


elhubProject(DEVXP, "devxp-ansible-collection-wsl") {

    params {
        param("env.CONTAINER_ENGINE", "docker")
    }

    val roles = listOf(
        "adr",
        "docker",
        "java",
        "kotlin",
        "node"
    )
    val moleculeTests: MutableList<BuildType> = mutableListOf()

    pipeline {
        parallel {
            roles.forEach {
                moleculeTests.add(moleculeTest(it).apply {
                    if (it == "adr") {
                        triggerOnVcsChange()
                    }
                })
            }

            customJob(
                AgentScope.LinuxAgentContext
            ) {
                id("RunAllMolecule")
                this.name = "Run all molecule tests"
                steps {
                    script {
                        scriptContent = """
                                echo hi
                        """.trimIndent()
                    }
                }
                dependencies {
                    moleculeTests.forEach {
                        snapshot(it.id!!) {
                            reuseBuilds = ReuseBuilds.NO
                        }
                    }
                }

            }
        }
    }
}
