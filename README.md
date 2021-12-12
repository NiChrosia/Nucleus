# Nucleus

An extensible registration library for all types of registries.

## Usage

```gradle
// build.gradle(.kts)
repositories {
    // [...]

    maven {
        name = "Modrinth"
        setUrl("https://api.modrinth.com/maven")
        content {
            includeGroup("maven.modrinth")
        }
    }

    // [...]
}

dependencies {
    // [...]

    modApi("maven.modrinth:nucleus:${nucleus_version}") // can be found from looking at the versions on the Modrinth page

    // [...]
}
```
