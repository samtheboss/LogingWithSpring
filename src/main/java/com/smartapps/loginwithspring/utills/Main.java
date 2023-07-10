//package com.smartapps.loginwithspring.utills;
//
//// Abstract class representing a vehicle
//abstract class Vehicle {
//    private String brand;
//    private String model;
//
//    public Vehicle(String brand, String model) {
//        this.brand = brand;
//        this.model = model;
//    }
//
//    public void start() {
//        System.out.println("Starting the " + brand + " " + model);
//    }
//
//    public abstract void drive();
//}
//
//// Concrete class representing a car, extending Vehicle
//class Car extends Vehicle {
//    private int numDoors;
//
//    public Car(String brand, String model, int numDoors) {
//        super(brand, model);
//        this.numDoors = numDoors;
//    }
//
//    @Override
//    public void drive() {
//        System.out.println("Driving the " + getBrand() + " " + getModel() + " with " + numDoors + " doors");
//    }
//}
//
//// Concrete class representing a motorcycle, extending Vehicle
//class Motorcycle extends Vehicle {
//    private boolean hasSidecar;
//
//    public Motorcycle(String brand, String model, boolean hasSidecar) {
//        super(brand, model);
//        this.hasSidecar = hasSidecar;
//    }
//
//
//    @Override
//    public void drive() {
//        System.out.println("Riding the " + getBrand() + " " + getModel() + (hasSidecar ? " with a sidecar" : ""));
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Car car = new Car("Toyota", "Camry", 4);
//        car.start();
//        car.drive();
//
//        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", false);
//        motorcycle.start();
//        motorcycle.drive();
//    }
//}
