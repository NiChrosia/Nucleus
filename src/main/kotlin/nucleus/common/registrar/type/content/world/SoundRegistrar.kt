package nucleus.common.registrar.type.content.world

import net.minecraft.sound.SoundEvent
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.SimpleVanillaRegistrar

open class SoundRegistrar(namespace: String) : SimpleVanillaRegistrar<SoundEvent>(namespace, Registry.SOUND_EVENT)