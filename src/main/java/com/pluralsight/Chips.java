package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Chips extends OrderedItems{
    private List<Chips> chips;

    public Chips(String Size) {
        super(Size);
        this.chips = new ArrayList<>();
    }
    public void addChips(Chips ChipType){
        if (!chips.contains(ChipType)) {
            chips.add(ChipType);
            System.out.println(ChipType + " has been added.\n");
        } else {
            System.out.println("This sauce is already on the sandwich.\n");
        }
    }
    public void removeChips(Chips chipType){
        chips.remove(chipType);
    }

    @Override
    public double itemPrice() {
        return 1.50;
    }
}
