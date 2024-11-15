package com.pluralsight.Ingredients;

import com.pluralsight.Chips;

public class BagChips extends Chips {
    public static final BagChips SunChips = new BagChips("Sun Chips");
    public static final BagChips Cheetos = new BagChips("Cheetos");
    public static final BagChips Lays = new BagChips("lays");
    public static final BagChips Doritos = new BagChips("Doritos");
    private String name;


    public BagChips(String size) {
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

