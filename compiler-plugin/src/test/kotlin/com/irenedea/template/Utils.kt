package com.irenedea.template

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import java.io.File

fun getResource(resourceName: String): SourceFile =
        SourceFile.fromPath(
                File(Thread.currentThread().contextClassLoader.getResource(resourceName)!!.path))

fun compile(
        sourceFiles: List<SourceFile>,
        plugin: ComponentRegistrar = TemplateComponentRegistrar(),
): KotlinCompilation.Result {
    return KotlinCompilation().apply {
        sources = sourceFiles
        useIR = true
        compilerPlugins = listOf(plugin)
        inheritClassPath = true
    }.compile()
}

fun compile(
        sourceFile: SourceFile,
        plugin: ComponentRegistrar = TemplateComponentRegistrar(),
): KotlinCompilation.Result {
    return compile(listOf(sourceFile), plugin)
}
