package nucleus.common.registrar

import nucleus.common.division.RegistrarRoot
import nucleus.common.member.Member

open class Registrar<K, V, R : RegistrarRoot<R>>(val root: R) {
    open val content = mutableMapOf<K, V>()
    open val members = mutableListOf<Member<K, V, *, R>>()

    open fun register(key: K, value: V): V {
        return value.also {
            content[key] = it
        }
    }

    open fun <T : V> memberOf(key: K, provider: (K) -> T): Member<K, V, T, R> {
        return Member(root, this, key, provider).also(members::add)
    }
}