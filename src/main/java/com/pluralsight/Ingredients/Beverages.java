package com.pluralsight.Ingredients;

import com.pluralsight.Drinks;

public class Beverages extends Drinks {
    public static final Beverages CocaCola = new Beverages("Coca-Cola");
    public static final Beverages Sprite = new Beverages("Sprite");
    public static final Beverages DrPepper = new Beverages("DrPepper");
    public static final Beverages LemonAid = new Beverages("Lemon-Aid");
    public static final Beverages Water = new Beverages("Water");
    private String name;


    public Beverages(String size) {
        super(size);
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
