package com.pluralsight;




public abstract class OrderedItems {

    protected String size;


    public OrderedItems(String Size){
        this.size = Size;
    }

    public double getSandwichSizePrice() {
        if (size.equalsIgnoreCase("large")) {
            return 8.50;
        } else if (size.equalsIgnoreCase("medium")) {
            return 7.50;
        } else
            return 5.5;
    }
    public abstract double itemPrice();

}
