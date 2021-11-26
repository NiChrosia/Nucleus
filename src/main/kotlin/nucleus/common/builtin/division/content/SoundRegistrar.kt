package nucleus.common.builtin.division.content

import net.minecraft.sound.SoundEvent
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.type.VanillaRegistrar

open class SoundRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<SoundEvent, R>(root, Registry.SOUND_EVENT)