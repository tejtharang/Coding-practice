package com.tej.DesignPatterns.FactoryPattern.Vehicles;

public class Motorcycle implements Vehicle{
    private int wheels;
    public Motorcycle(){
        this.wheels = 2;
    }

    public VehicleTypes getType(){
        return VehicleTypes.MOTORCYCLE;
    }
}
