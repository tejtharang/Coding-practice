package com.tej.DesignPatterns.FactoryPattern.Vehicles;

public class VehicleFactory {
    public Vehicle getVehicle(int wheels){
        switch(wheels){
            case 2:
                return new Motorcycle();

            case 3:
                return new Auto();

            case 4:
                return new Car();

            default:
                return new Car();


        }
    }
}
