package nucleus.common.impl.registrar.template

import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.world.gen.feature.ConfiguredFeature
import nucleus.common.impl.registrar.MinecraftRegistrar

open class ConfiguredFeatureRegistrar(namespace: String) : MinecraftRegistrar<ConfiguredFeature<*, *>>(BuiltinRegistries.CONFIGURED_FEATURE, namespace)