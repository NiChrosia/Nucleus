package nucleus.common.registrar.type.content.world

import net.minecraft.sound.SoundEvent
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class SoundRegistrar(namespace: String) : VanillaRegistrar<SoundEvent>(Registry.SOUND_EVENT, namespace)