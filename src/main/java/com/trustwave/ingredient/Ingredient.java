package com.trustwave.ingredient;

public class Ingredient {
    private String name;
    private double cost;

    public Ingredient(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String display(){
        return getName() + ", " + getCost();
    }
}
