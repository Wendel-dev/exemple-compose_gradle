import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins{
    kotlin("multiplatform") version "2.4.20"
    id("org.jetbrains.kotlin.plugin.compose") version "2.4.20"
    id("org.jetbrains.compose") version "1.12.1"
    id("org.jetbrains.compose.hot-reload") version "1.2.0"
}

kotlin {

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "composeApp"
        browser {
            commonWebpackConfig{
                outputFileName = "composeApp.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain{
            dependencies {
                implementation("org.jetbrains.compose.runtime:runtime:1.12.1")
                implementation("org.jetbrains.compose.foundation:foundation:1.12.1")
                implementation("org.jetbrains.compose.ui:ui:1.12.1")
                implementation("org.jetbrains.compose.components:components-resources:1.12.1")
                implementation("org.jetbrains.compose.material3:material3:1.12.0-alpha03")
                implementation("androidx.savedstate:savedstate-compose:1.5.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
            }
        }

        wasmJsMain {}

        wasmJsTest{}
    }
}
