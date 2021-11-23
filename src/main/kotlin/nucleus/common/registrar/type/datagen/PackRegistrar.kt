package nucleus.common.registrar.type.datagen

import net.devtech.arrp.api.RuntimeResourcePack
import nucleus.common.registrar.type.identity.IdentifyingRegistrar

open class PackRegistrar<V>(val pack: RuntimeResourcePack, namespace: String) : IdentifyingRegistrar<V>(namespace)