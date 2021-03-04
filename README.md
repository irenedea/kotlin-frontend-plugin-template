# Kotlin Frontend Plugin Template

## How to Use Locally

### Gradle Project
To publish to MavenLocal: 
```
./gradlew publish
```

#### Calling Project Configuration
In the calling project,

Apply the gradle plugin in `gradle.build.kts`:
```
plugins {
    id("com.irenedea.template") version "0.1.0-SNAPSHOT"
    // ... other plugins
}

// ... the rest of the build file
```

Make sure MavenLocal is listed as one of the gradle plugin repositories in `settings.gradle.kts`:
```
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
    }
}
// ... the rest of the settings file
```

### IDE Plugin

To build IDE plugin zip: 
```
./gradlew buildPlugin
```
The plugin zip should be in `ide-plugin/build/distributions`.

Note: Occasionally this will error, but running it `./gradlew clean buildPlugin` again seems to work. 🤷🏻‍♀️

#### Calling Project Configuration
In the calling project,

In IntelliJ, Go to `IntelliJ IDEA > Preferences... > Plugins > (Settings Logo in top bar) > Install Plugin from Disk...`, 
select the plugin zip, and restart IntelliJ to enable the plugin.

## Other Resources
Here are some resources for developing compiler plugins:
* Brian Norman's [Kotlin IR Plugin Template](https://github.com/bnorm/kotlin-ir-plugin-template) and his [compiler plugin blog series](https://blog.bnorm.dev/writing-your-second-compiler-plugin-part-1).
* [Kotlin Lang Slack](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up)
* Google Compose [compiler plugin](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/compiler/compiler-hosted/src/main/java/androidx/compose/compiler/plugins/kotlin/) and [IDE plugin](https://cs.android.com/android-studio/platform/tools/adt/idea/+/mirror-goog-studio-master-dev:compose-ide-plugin/src/com/android/tools/compose/)
* [Kotlin Serialization Plugin](https://github.com/JetBrains/kotlin/blob/master/plugins/kotlin-serialization/kotlin-serialization-compiler/README.md)
* [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
