package nucleus.common.registrar.category

import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.Registrar
import nucleus.common.registrar.base.datagen.PackRegistrar
import nucleus.common.registrar.base.identity.IdentifyingRegistrar
import nucleus.common.registrar.base.member.MemberRegistrar

/** A categorization of categories & registrars for easy mass loading. Intended to be implemented on a mod initializer
 * object, for access like `Nucleus.content.item.example`. */
open class RegistrarCategory(val namespace: String, val pack: RegistrarPack = RegistrarPack(namespace)) {
    val subcategories = mutableListOf<Lazy<RegistrarCategory>>()
    val registrars = mutableListOf<Lazy<Registrar<*, *>>>()

    /** Register a new IdentifyingRegistrar initializer to be loaded. */
    open fun <V, R : IdentifyingRegistrar<V>> registrar(provider: (String) -> R): Lazy<R> {
        return lazy { provider(namespace) }.also(registrars::add)
    }

    /** Register a new PackRegistrar initializer to be loaded. */
    open fun <V, R> registrar(
        provider: (String, RegistrarPack) -> R
    ): Lazy<R> where R : PackRegistrar, R : MemberRegistrar<V> {
        return lazy { provider(namespace, pack) }.also(registrars::add)
    }

    /** Register a new Registrar initializer to be loaded. */
    open fun <K, V, R : Registrar<K, V>> registrar(provider: () -> R): Lazy<R> {
        return lazy(provider).also(registrars::add)
    }

    /** Register a new subcategory to be loaded. */
    open fun <C : RegistrarCategory> subcategory(provider: (String, RegistrarPack) -> C): Lazy<C> {
        return lazy { provider(namespace, pack) }.also(subcategories::add)
    }

    /** Register & publish all content entries. */
    open fun launch() {
        register()
        publish()
    }

    /** Register all content declared within [MemberRegistrar.members]. */
    open fun register() {
        subcategories.forEach {
            val category = it.value
            category.register()
        }

        registrars.forEach {
            val registrar = it.value

            if (registrar is MemberRegistrar<*>) {
                registrar.registerContent()
            }
        }
    }

    /** Publish all content declared within registries. */
    open fun publish() {
        subcategories.forEach {
            val category = it.value
            category.publish()
        }

        registrars.forEach {
            val registrar = it.value
            registrar.publishContent()
        }

        pack.publish()
    }
}