package com.pluralsight;


import com.pluralsight.Ingredients.*;
import java.util.ArrayList;
import java.util.List;


public class CustomSandwiches extends OrderedItems {
    private List<Bread> bread;
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<Sauce> sauces;
    private List<RegularToppings> toppings;

    private boolean toasted;
    private boolean deluxeMeat;
    private boolean deluxeCheese;

    public CustomSandwiches(String sandwichSize, boolean toasted) {
        super(sandwichSize);
        this.bread = new ArrayList<>();
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.toasted = toasted;
        this.deluxeMeat = false;
        this.deluxeCheese = false;
    }

    // Add an item to the List
    public void addBread(Bread breadType) {
        if (!bread.contains(breadType)) {
            bread.add(breadType);
            System.out.println(breadType + " bread added.");
        } else {
            System.out.println("This bread type is already on the sandwich.");
        }
    }
    public void addMeat(Meat meatType) {
        if (!meats.contains(meatType)) {
            meats.add(meatType);
            System.out.println(meatType + " has been added.\n");
        } else {
            System.out.println("This meat type is already on the sandwich.\n");
        }
    }
    public void addCheese(Cheese cheeseType) {
        if (!cheeses.contains(cheeseType)) {
            cheeses.add(cheeseType);
            System.out.println(cheeseType + " has been added.\n");
        } else {
            System.out.println("This cheese type is already on the sandwich.\n");
        }
    }
    public void addSauce(Sauce sauceType) {
        if (!sauces.contains(sauceType)) {
            sauces.add(sauceType);
            System.out.println(sauceType + " has been added.\n");
        } else {
            System.out.println("This sauce is already on the sandwich.\n");
        }
    }
    public void addRegularToppings(RegularToppings toppingType) {
        if (!toppings.contains(toppingType)) {
            toppings.add(toppingType);
            System.out.println(toppingType + " has been added.\n");
        } else {
            System.out.println("This topping is already on the sandwich.\n");
        }
    }

    // Remove an item from the list
    public void removeBread(Bread breadType) {
        if (bread.remove(breadType)) {
            System.out.println(breadType + " bread removed.");
        } else {
            System.out.println("This bread type is not on the sandwich.");
        }
    }
    public void removeMeat(Meat meatType) {
        meats.remove(meatType);
    }
    public void removeCheese(Cheese cheeseType) {
        cheeses.remove(cheeseType);
    }
    public void removeSauce(Sauce sauceType) {
        sauces.remove(sauceType);
    }
    public void removeTopping(RegularToppings topping) {
        toppings.remove(topping);
    }

    @Override
    public double itemPrice() {
        return getSandwichPrice() + getCheesePrice() + getMeatPrice();
    }
    private double getSandwichPrice() {
        if(size.equalsIgnoreCase("large")){
                return 8.5;}
            else if(size.equalsIgnoreCase("medium")){
                return 7.0;}
            else{
                return 5.5;}
        };
    private double getMeatPrice() {

        if(size.equalsIgnoreCase("large")&& deluxeMeat){
            return 4.5;}
        else if (size.equalsIgnoreCase("large")){
            return 3.0;}
        else if(size.equalsIgnoreCase("medium")&& deluxeMeat){
            return 3.0;}
        else if(size.equalsIgnoreCase("medium")){
            return 2.0;}
        else if (size.equalsIgnoreCase("small")&& deluxeMeat){
            return 1.5;}
        else{
            return 1.0;}
        }
    private double getCheesePrice() {

        if(size.equalsIgnoreCase("large")&& deluxeCheese){
            return 4.5;}
        else if (size.equalsIgnoreCase("large")){
            return 3.0;}
        else if(size.equalsIgnoreCase("medium")&& deluxeCheese){
            return 3.0;}
        else if(size.equalsIgnoreCase("medium")){
            return 2.0;}
        else if (size.equalsIgnoreCase("small")&& deluxeCheese){
            return 1.5;}
        else{
            return 1.0;}
    }

    @Override
    public String toString() {
        return "CustomSandwich{" +
                "Size\n" + size +
                "Bread\n" + bread +
                "Is =" + toasted +
                "RegularToppings\n" + toppings +
                "Meats\n" + meats +
                "Cheeses\n" + cheeses +
                "DeluxeMeat\n" + deluxeMeat +
                "DeluxeCheese\n" + deluxeCheese +
                "Sauces\n" + sauces +
                "Total price-$" + itemPrice() +
                '}';
    }
};

