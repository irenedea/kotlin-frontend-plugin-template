@file:Suppress("unused") // usages in build scripts are not tracked properly

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val kotlinEmbeddableRootPackage = "org.jetbrains.kotlin"

val packagesToRelocate =
    listOf("com.intellij",
        "com.google",
        "com.sampullara",
        "org.apache",
        "org.jdom",
        "org.picocontainer",
        "org.jline",
        "kotlinx.coroutines",
        "net.jpountz",
        "one.util.streamex")


/*
 * Relocation logic taken from <KotlinRoot>/buildSrc/src/main/kotlin/embeddable.kt
 * Allows us to go from kotlin-compiler -> kotlin-compiler-embeddable
 */
fun ShadowJar.relocateCompilerPackages() {
    relocate("com.google.protobuf", "org.jetbrains.kotlin.protobuf")
    packagesToRelocate.forEach {
        relocate(it, "$kotlinEmbeddableRootPackage.$it")
    }
    relocate("org.fusesource", "$kotlinEmbeddableRootPackage.org.fusesource") {
        exclude("org.fusesource.jansi.internal.CLibrary")
    }
}
