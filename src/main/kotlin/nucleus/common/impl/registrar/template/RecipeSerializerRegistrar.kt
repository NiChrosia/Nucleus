package nucleus.common.impl.registrar.template

import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class RecipeSerializerRegistrar(namespace: String) : MinecraftRegistrar<RecipeSerializer<*>>(Registry.RECIPE_SERIALIZER, namespace)