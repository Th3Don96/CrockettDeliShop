package com.pluralsight;

public class Sandwich{

    private String bread, meatTypes, cheese, toppings,sauces;
    private int sandwichSize;
    private boolean toasted = true;

    public Sandwich(Integer sandwichSize, String meatTypes, String bread, String cheese, String toppings,String suaces) {
        this.sandwichSize = sandwichSize;
        this.meatTypes = meatTypes;
        this.bread = bread;
        this.cheese = cheese;
        this.toppings = toppings;
        this.sauces = suaces;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }
    public void setSandwichSize(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }
    public String getMeatTypes() {
        return meatTypes;
    }
    public void setMeatTypes(String meatTypes) {
        this.meatTypes = meatTypes;
    }
    public String getBread() {
        return bread;
    }
    public void setBread(String bread) {
        this.bread = bread;
    }
    public String getCheese() {
        return cheese;
    }
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }
    public String getToppings() {
        return toppings;
    }
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }
    public boolean isToasted() {
        return toasted;
    }
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    public String getSauces() {
        return sauces;
    }
    public void setSauces(String sauces) {
        this.sauces = sauces;
    }
}
