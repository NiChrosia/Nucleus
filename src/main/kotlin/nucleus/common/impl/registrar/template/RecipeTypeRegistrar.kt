package nucleus.common.impl.registrar.template

import net.minecraft.recipe.RecipeType
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class RecipeTypeRegistrar(namespace: String) : MinecraftRegistrar<RecipeType<*>>(Registry.RECIPE_TYPE, namespace)