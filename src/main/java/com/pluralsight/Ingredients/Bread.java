package com.pluralsight.Ingredients;

public class Bread {
    public static final Bread White = new Bread("White");
    public static final Bread Wheat= new Bread("Wheat");
    public static final Bread Rye = new Bread("Rye");
    public static final Bread Wrap = new Bread("Wrap");
    private String name;

    public Bread(String name) {
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

