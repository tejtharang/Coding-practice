package com.tej.DesignPatterns.FactoryPattern.Shapes;

public class Triangle implements Polygon{
    private int sides;
    public Triangle(){
        this.sides = 3;
    }
    public String getType(){
        return "Triangle";
    }

}
