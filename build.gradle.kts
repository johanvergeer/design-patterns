import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.apache.tools.ant.taskdefs.condition.Os.isFamily
import org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "me.jve23941"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val ktlint by configurations.creating

dependencies {
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.8.9")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.1")

    testImplementation(kotlin("test"))

    ktlint("com.pinterest:ktlint:0.43.2") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

val ktlintCheck by tasks.creating(JavaExec::class) {
    group = "formatting"
    description = "Check Kotlin code style deviations"
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")

    args = listOf("src/**/*.kt")
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}

val ktlintFormat by tasks.creating(JavaExec::class) {
    group = "formatting"
    description = "Check Kotlin code style deviations"
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")

    args = listOf("-F", "src/**/*.kt")
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
    inputs.files(inputFiles)
    outputs.dir(outputDir)
}

val installPreCommitHooks by tasks.creating(Copy::class) {
    group = "formatting"
    description = "Install custom pre-commit hooks"

    val suffix =
        if (isFamily(FAMILY_WINDOWS)) {
            "windows"
        } else {
            "macos"
        }

    from("scripts/pre-commit-$suffix")
        .into(".git/hooks")
        .rename("pre-commit-$suffix", "pre-commit")

    fileMode = 775
}

//task installGitHook(type: Copy) {
//    def suffix = "macos"
//    if (Os.isFamily(Os.FAMILY_WINDOWS)) {
//        suffix = "windows"
//    }
//    from new File(rootProject.rootDir, "scripts/pre-commit-$suffix")
//    into { new File(rootProject.rootDir, '.git/hooks') }
//    rename("pre-commit-$suffix", 'pre-commit')
//    fileMode 0775
//}
