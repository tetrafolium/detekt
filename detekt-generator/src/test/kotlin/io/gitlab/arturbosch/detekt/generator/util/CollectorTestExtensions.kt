package io.gitlab.arturbosch.detekt.generator.util

import io.github.detekt.test.utils.KtTestCompiler
import io.gitlab.arturbosch.detekt.generator.collection.Collector

fun <T> Collector<T>.run(code: String): List<T> {
    val ktFile = KtTestCompiler.compileFromContent(code.trimIndent())
    visit(ktFile)
    return items
}
