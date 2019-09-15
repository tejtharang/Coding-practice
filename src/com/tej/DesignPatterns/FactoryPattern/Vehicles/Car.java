package com.tej.DesignPatterns.FactoryPattern.Vehicles;

public class Car implements Vehicle{
    private int wheels;
    public Car(){
        this.wheels = 4;
    }
    public VehicleTypes getType(){
        return VehicleTypes.CAR;
    }
}
