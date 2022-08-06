package com.trustwave.ingredient;

public abstract class Ingredient {
    private String name;
    private double cost;

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
