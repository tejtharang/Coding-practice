package com.tej.DesignPatterns.FactoryPattern;

public class Pentagon implements Polygon{
    private int sides;
    public Pentagon(){
        sides = 5;
    }
    public String getType(){
        return "Pentagon";
    }
}
