enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "TCGDex"
include(":app")
include(":core:database")
include(":core:network")
include(":feature:pokemonlist:domain")
include(":feature:pokemonlist:data")
include(":feature:pokemonlist:ui")
include(":feature:pokemondetail:domain")
include(":feature:pokemondetail:data")
include(":feature:pokemondetail:ui")
