import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    vcsRoot(HttpsGithubComFjsnogueiraBookStoreJava21403linesGitRefsHeadsMaster)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComFjsnogueiraBookStoreJava21403linesGitRefsHeadsMaster)
    }

    steps {
        step {
            name = "checkmarx scan"
            type = "checkmarx"
            param("cxPresetId", "36")
            param("cxTeamId", "1")
            param("cxFilterPatterns", """
                !**/_cvs/**/*, !**/.svn/**/*,   !**/.hg/**/*,   !**/.git/**/*,  !**/.bzr/**/*, !**/bin/**/*,
                !**/obj/**/*,  !**/backup/**/*, !**/.idea/**/*, !**/*.DS_Store, !**/*.ipr,     !**/*.iws,
                !**/*.bak,     !**/*.tmp,       !**/*.aac,      !**/*.aif,      !**/*.iff,     !**/*.m3u,   !**/*.mid, !**/*.mp3,
                !**/*.mpa,     !**/*.ra,        !**/*.wav,      !**/*.wma,      !**/*.3g2,     !**/*.3gp,   !**/*.asf, !**/*.asx,
                !**/*.avi,     !**/*.flv,       !**/*.mov,      !**/*.mp4,      !**/*.mpg,     !**/*.rm,    !**/*.swf, !**/*.vob,
                !**/*.wmv,     !**/*.bmp,       !**/*.gif,      !**/*.jpg,      !**/*.png,     !**/*.psd,   !**/*.tif, !**/*.swf,
                !**/*.jar,     !**/*.zip,       !**/*.rar,      !**/*.exe,      !**/*.dll,     !**/*.pdb,   !**/*.7z,  !**/*.gz,
                !**/*.tar.gz,  !**/*.tar,       !**/*.gz,       !**/*.ahtm,     !**/*.ahtml,   !**/*.fhtml, !**/*.hdm,
                !**/*.hdml,    !**/*.hsql,      !**/*.ht,       !**/*.hta,      !**/*.htc,     !**/*.htd,   !**/*.war, !**/*.ear,
                !**/*.htmls,   !**/*.ihtml,     !**/*.mht,      !**/*.mhtm,     !**/*.mhtml,   !**/*.ssi,   !**/*.stm,
                !**/*.stml,    !**/*.ttml,      !**/*.txn,      !**/*.xhtm,     !**/*.xhtml,   !**/*.class, !**/node_modules/**/*, !**/*.iml
            """.trimIndent())
            param("cxProjectName", "BookStoreJava21403Lines_Build")
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComFjsnogueiraBookStoreJava21403linesGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/fjsnogueira/BookStoreJava_21403_lines.git#refs/heads/master"
    url = "https://github.com/fjsnogueira/BookStoreJava_21403_lines.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "fjsnogueira"
        password = "credentialsJSON:511dc76e-a881-4e60-819b-216d8a373292"
    }
})
