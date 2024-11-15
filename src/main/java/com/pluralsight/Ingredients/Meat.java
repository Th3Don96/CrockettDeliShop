package com.pluralsight.Ingredients;

public class Meat {
    public static final Meat Steak = new Meat("Steak");
    public static final Meat Ham = new Meat("Ham");
    public static final Meat Salami = new Meat("Salami");
    public static final Meat RoastBeef = new Meat("RoastBeef");
    public static final Meat Chicken  = new Meat("Chicken");
    public static final Meat Bacon = new Meat("Bacon");
    public static final Meat Turkey = new Meat("Turkey");
    private String name;
    private double price;
    private boolean Deluxe;

    public void DeluxeMeat(String name, double price, boolean deluxe) {
        this.name = name;
        this.price = price;
        this.Deluxe = deluxe;
    }

    public Meat(String name) {

    }
    public double getPrice() {
        return Deluxe ? price * 1.5 : price;
    }
    public String getName() {
        return name;
    }
    public boolean Deluxe() {
        return Deluxe;
    }
    public void setDeluxe(boolean deluxe) {
        Deluxe = deluxe;
    }

    @Override
    public String toString() {
        return name + (Deluxe ? " (deluxe)" : "");
    }
}
