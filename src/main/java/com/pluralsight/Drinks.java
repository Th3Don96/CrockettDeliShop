package com.pluralsight;

import com.pluralsight.Ingredients.Beverages;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends OrderedItems{
    private List<Beverages> beverages;
    private String name;

    public Drinks(String size) {
        super(size);
        this.beverages = new ArrayList<>();
    }
    public void addDrinks(Beverages beverageType) {
        if (!beverages.contains(beverageType)) {
            beverages.add(beverageType);
            System.out.println(beverageType + " has been added.\n");
        } else {
            System.out.println("This sauce is already on the sandwich.\n");
        }
    }
    void removeDrink(Drinks beverageType) {
        beverages.remove(beverageType);
    }

    @Override
    public double itemPrice() {
        if(size.equalsIgnoreCase("large")){
            return 8.5;}
        else if(size.equalsIgnoreCase("medium")){
            return 7.0;}
        else{
            return 5.5;}
    };
}
