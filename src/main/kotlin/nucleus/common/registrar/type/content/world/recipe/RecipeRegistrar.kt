package nucleus.common.registrar.type.content.world.recipe

import net.minecraft.recipe.RecipeType
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.SimpleVanillaRegistrar

open class RecipeRegistrar(namespace: String) : SimpleVanillaRegistrar<RecipeType<*>>(namespace, Registry.RECIPE_TYPE)