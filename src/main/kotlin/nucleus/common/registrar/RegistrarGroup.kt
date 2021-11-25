package nucleus.common.registrar

import net.minecraft.util.Identifier
import nucleus.common.extension.with

open class RegistrarGroup(val isRoot: Boolean = false, val namespace: String, val pack: RegistrarPack = RegistrarPack(namespace)) : RegistrarStage.User() {
    val subgroups = mutableListOf<RegistrarGroup>()
    val registrars = mutableListOf<Registrar<*, *>>()

    constructor(parent: RegistrarGroup) : this(false, parent.namespace, parent.pack)

    override fun register() {
        super.register()

        subgroups.forEach(RegistrarGroup::register)
        registrars.forEach(Registrar<*, *>::register)

        if (isRoot) pack.register()
    }

    override fun publish() {
        super.publish()

        subgroups.forEach(RegistrarGroup::publish)
        registrars.forEach(Registrar<*, *>::publish)

        if (isRoot) pack.publish()
    }

    override fun datagen() {
        super.datagen()

        subgroups.forEach(RegistrarGroup::datagen)
        registrars.forEach(Registrar<*, *>::datagen)

        if (isRoot) pack.datagen()
    }

    open fun launch() {
        register()
        publish()
        datagen()
    }

    open fun identify(path: String): Identifier {
        return namespace with path
    }

    open fun <K, V, R : Registrar<K, V>> R.collected(): R {
        return also(this@RegistrarGroup.registrars::add)
    }

    open fun <G : RegistrarGroup> G.collected(): G {
        return also(this@RegistrarGroup.subgroups::add)
    }
}