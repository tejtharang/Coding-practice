package com.tej.DesignPatterns.FactoryPattern;

public class Triangle implements Polygon{
    private int sides;
    public Triangle(){
        sides = 3;
    }
    public String getType(){
        return "Triangle";
    }

}
