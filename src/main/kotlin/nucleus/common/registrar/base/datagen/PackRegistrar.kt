package nucleus.common.registrar.base.datagen

import net.devtech.arrp.api.RuntimeResourcePack
import nucleus.common.registrar.base.identity.IdentifyingRegistrar

open class PackRegistrar<V>(val pack: RuntimeResourcePack, namespace: String) : IdentifyingRegistrar<V>(namespace)