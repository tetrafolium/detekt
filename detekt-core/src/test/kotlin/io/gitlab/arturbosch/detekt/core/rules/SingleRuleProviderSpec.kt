package io.gitlab.arturbosch.detekt.core.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.rules.providers.StyleGuideProvider
import io.gitlab.arturbosch.detekt.test.yamlConfigFromContent
import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

internal class SingleRuleProviderSpec : Spek({

    describe("SingleRuleProvider") {

        val provider = SingleRuleProvider("MagicNumber", StyleGuideProvider())

        context("the right sub config is passed to the rule") {

            fun produceRule(config: Config): Rule =
                provider.instance(config.subConfig("style")).rules.first() as Rule

            arrayOf("true", "false").forEach { value ->
                it("configures rule with active=$value") {
                    val config = yamlConfigFromContent("""
                    style:
                      MagicNumber:
                        active: $value
                """.trimIndent())

                    assertThat(produceRule(config).active).isEqualTo(value.toBoolean())
                }
            }
        }
    }
})
