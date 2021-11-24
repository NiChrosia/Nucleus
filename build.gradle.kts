import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// utility functions

@Suppress("unchecked_cast")
fun getProp(name: String): String {
    return project.ext[name] as String
}

fun DependencyHandler.bundledModImplementation(url: String): Dependency? {
    return include(url)?.let { modImplementation(it) }
}

// plugins

plugins {
    id("fabric-loom") version "0.10-SNAPSHOT"
    kotlin("jvm") version "1.5.30"
    kotlin("plugin.serialization") version "1.5.30"
}

// dependency managing

repositories {
    maven {
        name = "ARRP"
        setUrl("https://storage.googleapis.com/devan-maven/")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${getProp("minecraft_version")}")
    mappings("net.fabricmc:yarn:${getProp("yarn_mappings")}:v2")

    modImplementation("net.fabricmc:fabric-loader:${getProp("loader_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${getProp("fabric_api_version")}")
    modImplementation("net.fabricmc:fabric-language-kotlin:${getProp("fabric_kotlin_version")}")

    bundledModImplementation("net.devtech:arrp:${getProp("arrp_version")}")

    implementation("com.googlecode.soundlibs:vorbisspi:1.0.3-1")
}

// configuration

base {
    archivesName.set(getProp("archives_base_name"))
    version = getProp("mod_version")
    group = getProp("maven_group")
}

loom {
    accessWidenerPath.set(file("src/main/resources/nucleus.accesswidener"))

    runs {
        create("serverTest") {
            server()
            source(sourceSets.main.get())
            vmArg("-Dfabric-api.gametest=1")
        }
    }
}

tasks {
    "compileJava"(JavaCompile::class) {
        options.encoding = "UTF-8"
        options.release.set(16)
    }

    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_16.toString()
            freeCompilerArgs = listOf("-XXLanguage:+NewInference")
        }
    }

    "processResources"(ProcessResources::class) {
        // expand ${version} in fabric.mod.json
        val modVersion = getProp("mod_version")

        inputs.property("version", modVersion)

        filesMatching("fabric.mod.json") {
            expand("version" to modVersion)
        }
    }

    "jar"(Jar::class) {
        from("LICENSE") {
            rename { "${it}_${base.archivesName.get()}"}
        }
    }
}