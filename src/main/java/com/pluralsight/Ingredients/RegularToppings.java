package com.pluralsight.Ingredients;

public class RegularToppings {
    public static final RegularToppings Lettuce = new RegularToppings("Lettuce");
    public static final RegularToppings Peppers = new RegularToppings("Peppers");
    public static final RegularToppings Onions = new RegularToppings("Onions");
    public static final RegularToppings Tomatoes = new RegularToppings("Tomatoes");
    public static final RegularToppings Jalapenos = new RegularToppings("Jalapenos");
    public static final RegularToppings Cucumbers = new RegularToppings("Cucumbers");
    public static final RegularToppings Pickles = new RegularToppings("Pickles");
    public static final RegularToppings BananaPeppers = new RegularToppings("Banana Peppers");
    public static final RegularToppings Mushrooms = new RegularToppings("Mushrooms");
    private final String name;

    public RegularToppings(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
