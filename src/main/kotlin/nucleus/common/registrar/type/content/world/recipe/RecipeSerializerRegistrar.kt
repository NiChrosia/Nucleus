package nucleus.common.registrar.type.content.world.recipe

import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.SimpleVanillaRegistrar

open class RecipeSerializerRegistrar(namespace: String) : SimpleVanillaRegistrar<RecipeSerializer<*>>(namespace, Registry.RECIPE_SERIALIZER)