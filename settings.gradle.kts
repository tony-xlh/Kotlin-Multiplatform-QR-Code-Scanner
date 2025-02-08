enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven (url="https://download2.dynamsoft.com/maven/aar")
    }
}

rootProject.name = "BarcodeScanner"
include(":androidApp")
include(":shared")