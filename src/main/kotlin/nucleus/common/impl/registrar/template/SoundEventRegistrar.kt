package nucleus.common.impl.registrar.template

import net.minecraft.sound.SoundEvent
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class SoundEventRegistrar(namespace: String) : MinecraftRegistrar<SoundEvent>(Registry.SOUND_EVENT, namespace)