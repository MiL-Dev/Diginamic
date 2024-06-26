package fr.diginamic.builder;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.factory.Additive;
import fr.diginamic.factory.Allergen;
import fr.diginamic.factory.Ingredient;
import fr.diginamic.factory.Unite;

public class Product {
    private String name;
    private String rank;

    private Category category;
    private Marque brand;

    private List<Additive> additives = new ArrayList<>();
    private List<Allergen> allergens = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();

    public Product appendName(String name){
        setName(name);
        return this;
    }

    public Product appendRank(String rank){
        setRank(rank);;
        return this;
    }

    public Product appendCategory(String name){
        setCategory(new Category(name));
        return this;
    }

    public Product appendBrand(String name){
        setBrand(new Marque(name));
        return this;
    }

    public Product appendAdditive(String name, double value, Unite unite ){
        addAdditive(new Additive(name, value, unite));
        return this;
    }

    public Product appendAllergen(String name, double value, Unite unite ){
        addAllergen(new Allergen(name, value, unite));
        return this;
    }

    public Product appendIngredient(String name, double value, Unite unite ){
        addIngredient(new Ingredient(name, value, unite));
        return this;
    }

    public Product build(){
        return this;
    }

    public List<Additive> getAdditives() {
        return additives;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public Marque getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public void addAdditive(Additive additive) {
        this.additives.add(additive);
    }

    public void addAllergen(Allergen allergen) {
        this.allergens.add(allergen);
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setAdditives(List<Additive> additives) {
        this.additives = additives;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

    public void setBrand(Marque brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
