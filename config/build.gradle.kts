publishing {
    publications {
        create<MavenPublication>("config") {
            from(components["java"])
        }
    }
}