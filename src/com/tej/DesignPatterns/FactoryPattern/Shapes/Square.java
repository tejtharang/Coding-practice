package com.tej.DesignPatterns.FactoryPattern.Shapes;

public class Square implements Polygon{
    private int sides;
    public Square(){
        this.sides = 4;
    }
    public String getType(){
        return "Square";
    }
}
