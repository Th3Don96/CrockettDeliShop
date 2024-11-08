package com.pluralsight;

public abstract class MeatTypes extends Sandwich{

    String steak = steak;
    String ham = ham;
    String salami = salami;
    String roastBeef = roastBeef;
    String chicken = chicken;
    String bacon = bacon;
    String turkey = turkey;

    public MeatTypes(Integer sandwichSize, String meatTypes, String bread, String cheese, String toppings, String suaces) {
        super(sandwichSize, meatTypes, bread, cheese, toppings, suaces);
        this.steak = getSteak();
        this.ham = getHam();
        this.salami = getSalami();
        this.roastBeef =getRoastBeef();
        this.chicken =getChicken();
        this.bacon =getBacon();
        this.turkey =getTurkey();
    }

    public String getSteak() {
        return steak;
    }
    public void setSteak(String steak) {
        this.steak = steak;
    }
    public String getHam() {
        return ham;
    }
    public void setHam(String ham) {
        this.ham = ham;
    }
    public String getSalami() {
        return salami;
    }
    public void setSalami(String salami) {
        this.salami = salami;
    }
    public String getRoastBeef() {
        return roastBeef;
    }
    public void setRoastBeef(String roastBeef) {
        this.roastBeef = roastBeef;
    }
    public String getChicken() {
        return chicken;
    }
    public void setChicken(String chicken) {
        this.chicken = chicken;
    }
    public String getBacon() {
        return bacon;
    }
    public void setBacon(String bacon) {
        this.bacon = bacon;
    }
    public String getTurkey() {
        return turkey;
    }
    public void setTurkey(String turkey) {
        this.turkey = turkey;
    }
}
