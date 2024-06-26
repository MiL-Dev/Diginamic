package fr.diginamic.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ElementFactoryTest {
    /** DELTA */
	private static final double DELTA = 0.0000001;

    @Test
    public void shouldReturnAdditiveElement(){
        String expectedName = "Additive";
        double expectedValue = 25;
        Unite expectedUnite = Unite.MICRO_GRAMS;
        Element element = ElementFactory.create(ElementType.ADDITIVE, expectedName, expectedValue, expectedUnite);

        assertTrue(element instanceof Additive);
        testAttributes(element, expectedName, expectedValue, expectedUnite);
    }

    @Test
    public void shouldReturnAllergenElement(){
        String expectedName = "Allergen";
        double expectedValue = 45;
        Unite expectedUnite = Unite.MILLI_GRAMS;
        Element element = ElementFactory.create(ElementType.ALLERGEN, expectedName, expectedValue, expectedUnite);

        assertTrue(element instanceof Allergen);
        testAttributes(element, expectedName, expectedValue, expectedUnite);
    }

    @Test
    public void shouldReturnIngredientElement(){
        String expectedName = "Ingredient";
        double expectedValue = 50;
        Unite expectedUnite = Unite.MILLI_GRAMS;
        Element element = ElementFactory.create(ElementType.INGREDIENT, expectedName, expectedValue, expectedUnite);

        assertTrue(element instanceof Ingredient);
        testAttributes(element, expectedName, expectedValue, expectedUnite);
    }

    @Test
    public void shouldReturnNull(){
        String expectedName = "Null";
        double expectedValue = 50;
        Unite expectedUnite = Unite.MILLI_GRAMS;
        Element element = ElementFactory.create(null, expectedName, expectedValue, expectedUnite);

        assertNull(element);
    }

    private void testAttributes(Element element, String name, double value, Unite unite){
        assertEquals(name, element.getName());
        assertEquals(value, element.getValue(), DELTA);
        assertEquals(unite, element.getUnite());
    }
}
