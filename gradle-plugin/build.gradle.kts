plugins {
  id("java-gradle-plugin")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("gradle-plugin-api"))
  implementation(project(":config"))
}

gradlePlugin {
  plugins {
    create("template") {
      id = "com.irenedea.template"
      implementationClass = "com.irenedea.template.TemplateGradlePlugin"
    }
  }
}
