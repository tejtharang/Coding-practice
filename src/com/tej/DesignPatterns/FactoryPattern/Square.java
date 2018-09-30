package com.tej.DesignPatterns.FactoryPattern;

public class Square implements Polygon{
    private int sides;
    public Square(){
        sides = 4;
    }
    public String getType(){
        return "Square";
    }
}
