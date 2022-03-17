plugins {
    kotlin("jvm") version "1.5.10"
    id("fabric-loom")
    `maven-publish`
    java
}

// TODO - make testmod version actually functional

group = property("maven_group")!!
version = property("mod_version")!!

repositories {
    // Add repositories to retrieve artifacts from in here.
    // You should only use this when depending on other mods because
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
    // for more information about repositories.
}

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "fabric-loom")
    apply(plugin = "maven-publish")
    apply(plugin = "java")

    sourceSets {
        create("testmod") {
            compileClasspath += main.get().compileClasspath
            compileClasspath += main.get().output

            runtimeClasspath += main.get().runtimeClasspath
        }
    }

    dependencies {
        minecraft("com.mojang:minecraft:${property("minecraft_version")}")
        mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")
        modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

        modImplementation("net.fabricmc:fabric-language-kotlin:${property("fabric_kotlin_version")}")
        modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")
    }
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE")
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                artifact(remapJar) {
                    builtBy(remapJar)
                }

                artifact(kotlinSourcesJar) {
                    builtBy(remapSourcesJar)
                }
            }
        }

        // select the repositories you want to publish to
        repositories {
            // uncomment to publish to the local maven
            // mavenLocal()
            mavenLocal()
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "16"
    }
}

loom {
    accessWidenerPath.set(File("$rootDir/src/main/resources/nucleus.accesswidener"))

    runs {
        create("testmodClient") {
            inherit(getByName("client"))

            configName = "Testmod Client"

            source(sourceSets.getByName("testmod"))
        }

        create("testmodServer") {
            inherit(getByName("server"))

            configName = "Testmod Server"

            source(sourceSets.getByName("testmod"))
        }
    }
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}

// configure the maven publication
