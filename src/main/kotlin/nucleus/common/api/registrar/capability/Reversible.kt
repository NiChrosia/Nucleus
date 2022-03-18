package nucleus.common.api.registrar.capability

/** A registrar capability that allows value-to-key identification. */
interface Reversible<K, V> {
    fun identify(value: V): K

    fun noKeyFound(value: V): IllegalArgumentException {
        return IllegalArgumentException("No such key found for given value '$value.'")
    }
}