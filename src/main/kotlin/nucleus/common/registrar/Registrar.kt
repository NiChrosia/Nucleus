package nucleus.common.registrar

import nucleus.common.Nucleus
import nucleus.common.member.Member

open class Registrar<K, V>(open val group: RegistrarGroup) : RegistrarStage.User() {
    protected val content = mutableMapOf<K, V>()
    protected val members: MutableList<Member<K, V, *>> = mutableListOf()

    override fun register() {
        super.register()

        members.forEach(Member<K, V, *>::register)
    }

    override fun publish() {
        super.publish()

        members.forEach(Member<K, V, *>::publish)
    }

    override fun datagen() {
        super.datagen()

        members.forEach(Member<K, V, *>::datagen)
    }

    open fun register(key: K, value: V) {
        if (content[key] != null) {
            Nucleus.log.warn("Registering pre-existing entry at (key: $key, value: $value), overriding.")
        }

        content[key] = value
    }

    open fun find(key: K): V? {
        return content[key]
    }

    open fun <T : V> member(key: K, provider: (K) -> T): Member<K, V, T> {
        return Member(this, key, provider).also(members::add)
    }
}