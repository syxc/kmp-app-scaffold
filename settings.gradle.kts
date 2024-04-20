@file:Suppress("UnstableApiUsage")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
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

rootProject.name = "kmp-app-scaffold"

include(":kmp-app-shared")
include(":kmp-app-android-scaffold")

check(JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17)) {
  "This project needs to be run with Java 17 or higher (found: ${JavaVersion.current()})."
}
