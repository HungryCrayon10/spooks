package net.hungry.spooks.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import java.util.concurrent.CompletableFuture;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.item.Items;
import net.hungry.spooks.register.SpooksBlocks;

public class SpooksRecipes extends FabricRecipeProvider {
    public SpooksRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SOUL_SOIL, 3)
                .pattern("BBB")
                .pattern("HHH")
                .pattern("RRR")
                .input('B', Items.BONE)
                .input('R', Items.ROTTEN_FLESH)
                .input('H', SpooksBlocks.HOLLOWED_GROUND)
                .group("re-soul")
                .criterion(FabricRecipeProvider.hasItem(SpooksBlocks.HOLLOWED_GROUND), FabricRecipeProvider.conditionsFromItem(SpooksBlocks.HOLLOWED_GROUND))
                .offerTo(recipeExporter);
    }
}
