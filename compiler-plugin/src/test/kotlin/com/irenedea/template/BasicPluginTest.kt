package com.irenedea.template

import com.tschuchort.compiletesting.KotlinCompilation
import kotlin.test.assertEquals
import org.junit.Test

class BasicPluginTest {
    @Test
    fun `plugin success`() {
        val result = compile(
        sourceFile = getResource("Test.kt")
        )
        assertEquals(KotlinCompilation.ExitCode.OK, result.exitCode)
        }
    }

