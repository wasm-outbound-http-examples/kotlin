// Partially based on https://github.com/Kotlin/kotlin-wasm-examples/tree/main/browser-example
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform") version "1.9.21"
}

group = "io.github.wasm_outbound_http_examples.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmJs {
        binaries.executable()
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(project.rootDir.path)
                    }
                }
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val wasmJsMain by getting
    }
}
