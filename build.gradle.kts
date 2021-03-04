
plugins {
  kotlin("jvm") version "1.4.20"
  `maven-publish`
}

allprojects {
  apply(plugin = "maven-publish")
  apply(plugin = "kotlin")

  repositories {
    mavenCentral()
    jcenter()
  }

  publishing {
    repositories {
      mavenLocal()
    }
  }

  group = "com.irenedea.template"
  version = "0.1.0-SNAPSHOT"

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
  }
}
