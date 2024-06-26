package fr.diginamic.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.diginamic.factory.Unite;

public class ProductTest {

    @Test
    public void shouldBuildProduct() {
        String name1 = "Barre de Chocolat";
        String rank1 = "E";
        String category1 = "Sucré";
        String brand1 = "brand";

        String additifName = "Additive";
        double additifValue = 25;
        Unite additiveUnite = Unite.MICRO_GRAMS;

        String allergenName = "Allergen";
        double allergenValue = 45;
        Unite allergenUnite = Unite.MILLI_GRAMS;

        String ingredientName = "Ingredient";
        double ingredientValue = 50;
        Unite ingredientUnite = Unite.MILLI_GRAMS;

        Product product = new Product();
        product.appendName(name1)
                .appendRank(rank1);

        assertEquals(name1, product.getName());
        assertEquals(rank1, product.getRank());

        product.appendCategory("Sucré")
                .appendBrand("brand");

        assertTrue(category1.equals(product.getCategory().getName()));
        assertTrue(brand1.equals(product.getBrand().getName()));

        product.appendAdditive(additifName, additifValue, additiveUnite)
                .appendAllergen(allergenName, allergenValue, allergenUnite)
                .appendIngredient(ingredientName, ingredientValue, ingredientUnite);

        assertTrue(product.getAdditives().stream()
                .anyMatch(additive -> additive.getName().equals(additifName)
                        && additive.getValue() == additifValue
                        && additive.getUnite() == additiveUnite));

        assertTrue(product.getAllergens().stream()
                .anyMatch(allergen -> allergen.getName().equals(allergenName)
                        && allergen.getValue() == allergenValue
                        && allergen.getUnite() == allergenUnite));

        assertTrue(product.getIngredients().stream()
                .anyMatch(ingredient -> ingredient.getName().equals(ingredientName)
                        && ingredient.getValue() == ingredientValue
                        && ingredient.getUnite() == ingredientUnite));
    }
}
