package com.pluralsight;

import java.util.ArrayList;


public class CurrentOrder {

    private ArrayList<CustomSandwiches> items;
    private ArrayList<Drinks> drinksItems;
    private ArrayList<Chips> chipsItems;

    public CurrentOrder() {
        items = new ArrayList<>();
        drinksItems = new ArrayList<>();
        chipsItems = new ArrayList<>();
    }
    public ArrayList<CustomSandwiches> getItems(){
        return items;
    }
    public ArrayList<Drinks> getDrinkItems(){
        return drinksItems;
    }
    public ArrayList<Chips> getChipItems(){
        return chipsItems;
    }
    public void addItem(CustomSandwiches item) {
        items.add(item);
    }
    public void addDrinkItem(Drinks beverages){
        drinksItems.add(beverages);
    }
    public void addChipItem(Chips bagChips){
        chipsItems.remove(bagChips);
    }
    public void cancelOrder() {
        items.clear();
        drinksItems.clear();
        chipsItems.clear();
    }
    public double getTotalCost() {
        return items.stream().mapToDouble(CustomSandwiches::getSandwichSizePrice).reduce(0, Double::sum) +
        drinksItems.stream().mapToDouble(Drinks::itemPrice).reduce(0, Double::sum) +
        chipsItems.stream().mapToDouble(Chips::itemPrice).reduce(0, Double::sum);
    }
    public void listOrder() {
        System.out.println("Your order:");
        System.out.println("Sandwiches:\n");
        this.items.forEach(System.out::println);
        System.out.println("Drinks:\n");
        this.drinksItems.forEach(System.out::println);
        System.out.println("Chips:\n");
        this.chipsItems.forEach(System.out::println);
        System.out.println();
        double cost = getTotalCost();
        System.out.println("Cost: $" + cost);
    }


}