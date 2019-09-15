package com.tej.DesignPatterns.FactoryPattern.Shapes;

public class PolygonFactory {
    public Polygon getPolygon(int sides){
        if(sides == 3){
            return new Triangle();
        }
        if(sides == 4){
            return new Square();
        }
        if(sides == 5){
            return new Pentagon();
        }
        return null;

    }
}
