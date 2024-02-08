// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    // trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinCocoapods) apply false
}

subprojects {
    project.configurations.configureEach {
        // Whilst the compileSdk is < 34
        // force the version of these dependencies
        // we don't use them, but they are pulled in by the compose dependencies
        resolutionStrategy {
            force("androidx.emoji2:emoji2:1.3.0")
            force("androidx.emoji2:emoji2-views:1.3.0")
            force("androidx.emoji2:emoji2-views-helper:1.3.0")
        }
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
