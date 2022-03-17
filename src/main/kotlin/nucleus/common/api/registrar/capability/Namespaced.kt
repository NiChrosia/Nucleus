package nucleus.common.api.registrar.capability

import net.minecraft.util.Identifier
import nucleus.common.api.registrar.Registrar

interface Namespaced<T> {
    val namespace: String

    /** shaded method, see [Registrar.register] */
    fun <V : T> register(key: Identifier, value: V): V

    fun <V : T> register(path: String, value: V): V {
        return register(Identifier(namespace, path), value)
    }
}