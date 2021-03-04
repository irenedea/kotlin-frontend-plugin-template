plugins {
    id("org.jetbrains.intellij") version "0.7.1"
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}

intellij {
    pluginName = "tensortyping"
    version = "2020.2"
    type = "IC"
    updateSinceUntilBuild = false
}

dependencies {
    implementation(project(":compiler-plugin"))
    compileOnly("org.jetbrains.kotlin:kotlin-compiler")
}
tasks {
    runPluginVerifier {
        ideVersions("2020.2.4, 2020.3.2, 2021.1")
    }
}
