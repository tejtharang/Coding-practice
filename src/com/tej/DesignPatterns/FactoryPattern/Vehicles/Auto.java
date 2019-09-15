package com.tej.DesignPatterns.FactoryPattern.Vehicles;

public class Auto implements Vehicle {
    private int wheels;
    public Auto(){
        wheels = 3;
    }

    public VehicleTypes getType(){
        return VehicleTypes.AUTO;
    }
}
