package com.irenedea.template

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor


@AutoService(ComponentRegistrar::class)
class TemplateComponentRegistrar: ComponentRegistrar {
  override fun registerProjectComponents(
    project: MockProject,
    configuration: CompilerConfiguration
  ) {
    StorageComponentContainerContributor.registerExtension(project,
      TemplateContainerContributor()
    )
  }
}


