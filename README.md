# Nucleus

An extensible registration library for all types of registries.

## Installation

In your Gradle buildscript, you need to do two steps: the repository, and the dependency. If you already have the modrinth
maven repository, [skip this step](#dependency).

### Modrinth repository

```kotlin
repositories {
    maven {
        name = "Modrinth"
        setUrl("https://api.modrinth.com/maven/")
        
        content {
            includeGroup("maven.modrinth")
        }
    }
}
```

### Dependency

Next, you need to add the dependency. The versions can be found on [the modrinth page](https://modrinth.com/mod/nucleus/versions).

```kotlin
dependencies {
    modApi("maven.modrinth:nucleus:${nucleus_version}")
}
```