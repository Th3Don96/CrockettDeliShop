package com.pluralsight.Ingredients;

public class Sauce {
    public static final Sauce Mayo = new Sauce("Mayo");
    public static final Sauce Mustard = new Sauce("Mustard");
    public static final Sauce Ketchup = new Sauce("Ketchup");
    public static final Sauce Ranch = new Sauce("Ranch");
    public static final Sauce BBQ = new Sauce("BBQ");
    public static final Sauce HoneyMustard = new Sauce("Honey Mustard");
    private String name;

    public Sauce(String name) {
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
