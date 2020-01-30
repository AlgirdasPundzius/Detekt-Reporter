import studio.forface.easygradle.dsl.`kotlin-test-junit`
import studio.forface.easygradle.dsl.`kotlin-test`
import studio.forface.easygradle.dsl.kotlin
import studio.forface.easygradle.dsl.publish

buildscript {
    val kotlinVersion = "1.3.21"
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        // noinspection all
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("studio.forface.easygradle:dsl:0.16")
    }
}

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.3.21"
}

group = "pm.algirdas"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(kotlin)
    compile("com.google.code.gson:gson:2.8.5")
    implementation("io.gitlab.arturbosch.detekt:detekt-api:1.5.0")
    testCompile(`kotlin-test`)
    testCompile(`kotlin-test-junit`)
}

publish {
    projectName = null

    version = "0.2.0"
    bintrayGroup = "pm.algirdas"
    groupId = "detekt"
    groupName = "Detekt"
    artifact = "codeanalysis"
    gitUrl = "https://github.com/AlgirdasPundzius/Detekt-Reporter"
    licenses {
        license {
            name = "MIT"
            url = "https://opensource.org/licenses/MIT"
        }
    }
    override = true
}

