package com.pluralsight.Ingredients;

public class Cheese {
    public static final Cheese American = new Cheese("American");
    public static final Cheese Provolone= new Cheese("Provolone");
    public static final Cheese Cheddar = new Cheese("Cheddar");
    public static final Cheese Swiss = new Cheese("Swiss");
    private String name;
    private double cost;
    private boolean deluxe;

    public void DeluxeCheese(String name, double cost, boolean deluxe) {
        this.name = name;
        this.cost = cost;
        this.deluxe = deluxe;
    }

    public Cheese(String name) {

    }

    public double getCost() {
        return deluxe ? cost * 1.5 : cost;
    }
    public String getName() {
        return name;
    }
    public boolean Deluxe() {
        return deluxe;
    }
    public void setDeluxe(boolean deluxe) {
        this.deluxe = deluxe;
    }
    @Override
    public String toString() {
        return name + (deluxe ? " (deluxe)" : "");
    }
}
