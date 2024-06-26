package fr.diginamic.factory;

public class ElementFactory {
    public static Element create(ElementType type, String name, double value, Unite unite) {

        if(type == null)
            return null;

        switch (type) {
            case ADDITIVE:
                return new Additive(name, value, unite);

            case INGREDIENT:
                return new Ingredient(name, value, unite);

            case ALLERGEN:
                return new Allergen(name, value, unite);

            default:
                return null;
        }
    }
}
