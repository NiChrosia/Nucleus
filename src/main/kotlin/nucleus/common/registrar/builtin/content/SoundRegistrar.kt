package nucleus.common.registrar.builtin.content

import net.minecraft.sound.SoundEvent
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.builtin.content.ContentGroup
import nucleus.common.registrar.type.VanillaRegistrar

open class SoundRegistrar(override val group: ContentGroup) : VanillaRegistrar<SoundEvent>(group, Registry.SOUND_EVENT)