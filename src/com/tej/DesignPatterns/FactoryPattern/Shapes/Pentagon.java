package com.tej.DesignPatterns.FactoryPattern.Shapes;

public class Pentagon implements Polygon{
    private int sides;
    public Pentagon(){
        this.sides = 5;
    }
    public String getType(){
        return "Pentagon";
    }
}
