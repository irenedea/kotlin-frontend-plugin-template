import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
  kotlin("kapt")
  id("com.github.johnrengelman.shadow")
}

tasks.withType<ShadowJar> {
  from(sourceSets.main.get().output)

  // Relocate imported compiler packages to match kotlin-compiler-embeddable
  relocateCompilerPackages()
}

// The dependency com.github.tschuchortdev:kotlin-compile-testing requires kotlin-compiler-embeddable
// so we need to use the relocated shadowJar.
tasks.withType<Test> {
  // Run shadowJar task first
  dependsOn(tasks.shadowJar)

  // Add shadowJar to classpath for tests
  this.classpath += tasks.shadowJar.get().outputs.files
  // Remove the old classpaths that are replaced by the shadowJar
  this.classpath -= sourceSets.main.get().runtimeClasspath
}

// Publishing
val pluginJar by tasks.registering(ShadowJar::class)

publishing {
  publications {
    create<MavenPublication>("compiler-plugin") {
      artifact(pluginJar)
    }
  }
}

dependencies {
  implementation(project(":config"))
  compileOnly("org.jetbrains.kotlin:kotlin-compiler")

  kapt("com.google.auto.service:auto-service:1.0-rc7")
  compileOnly("com.google.auto.service:auto-service-annotations:1.0-rc7")


  testImplementation(kotlin("test-junit"))
  testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable")
  testImplementation("com.github.tschuchortdev:kotlin-compile-testing:1.3.6")
}
