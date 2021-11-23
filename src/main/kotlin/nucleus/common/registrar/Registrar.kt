package nucleus.common.registrar

/** The core of the Nucleus registration system. */
open class Registrar<K, V> {
    /** The registry object for containing content entries.  */
    open val registry = Registry<K, V>()

    /** Register the specified [key] and [value] to the [registry]. */
    open fun register(key: K, value: V) = registry.register(key, value)

    /** Publish the specified [key] and [value] to external registries. */
    open fun publish(key: K, value: V) = value

    /** Publish all content contained within the [registry]. */
    open fun publishContent() {
        registry.content.forEach(this::publish)
    }
}