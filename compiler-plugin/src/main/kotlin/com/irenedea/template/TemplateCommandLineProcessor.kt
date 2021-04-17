package com.irenedea.template

import com.google.auto.service.AutoService
import config.BuildConfig
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor


@AutoService(CommandLineProcessor::class)
class TemplateCommandLineProcessor : CommandLineProcessor {

  override val pluginId: String = BuildConfig.KOTLIN_PLUGIN_ID

  override val pluginOptions: Collection<CliOption> = listOf()

}
