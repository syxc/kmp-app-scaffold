@file:Suppress("UnstableApiUsage")

buildscript {
  repositories {
    gradlePluginPortal()
    google {
      content {
        includeGroupByRegex(".*google.*")
        includeGroupByRegex(".*android.*")
      }
    }
    mavenCentral()
  }
}

allprojects {
  repositories {
    google {
      content {
        includeGroupByRegex(".*google.*")
        includeGroupByRegex(".*android.*")
      }
    }
    mavenCentral()
  }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kotlin.cocoapods) apply false
}

subprojects {
  project.configurations.configureEach {
    // Whilst the compileSdk is < 34
    // force the version of these dependencies
    // we don't use them, but they are pulled in by the compose dependencies
    resolutionStrategy {
      // force("androidx.emoji2:emoji2:1.3.0")
      // force("androidx.emoji2:emoji2-views:1.3.0")
      // force("androidx.emoji2:emoji2-views-helper:1.3.0")
    }
  }
}

tasks {
  register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
  }
}
