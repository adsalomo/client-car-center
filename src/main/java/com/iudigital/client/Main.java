package com.iudigital.client;

import com.iudigital.client.dto.Car;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static void createCar(Scanner sc, CarClient carClient) {
        
        Car car = new Car();
        
        System.out.println("****** Por favor digite los siguientes datos ******");
        
        System.out.println("Placa");
        car.setLicencePlate(sc.next());
        
        System.out.println("Color");
        car.setColor(sc.next());
        
        System.out.println("Modelo");
        car.setModel(sc.next());
        
        System.out.println("Marca");
        car.setBrand(sc.next());
        
        System.out.println("Año");
        car.setYear(sc.next());
        
        System.out.println("Tipo combustible");
        car.setFuelType(sc.next());
        
        System.out.println("Numero de puertas");
        car.setNumberDoors(sc.next());
        
        System.out.println("Transmisión");
        car.setTransmission(sc.next());
        
        System.out.println("Motor");
        car.setMotor(sc.next());
        
        System.out.println("Kilometros");
        car.setKilometres(sc.next());
        
        System.out.println("Foto");
        car.setPhoto(sc.next());
      
        carClient.createCar(car);
        
        System.out.println("****** Carro creado con exito ******");
        
    }
    
    private static void getCars(CarClient carClient) {
        
        System.out.println("****** Listado de Carros ******");
        
        for(Car car : carClient.getCars()) {
            System.out.println("=======================");
            System.out.println("Placa: " + car.getLicencePlate());
            System.out.println("Color: " + car.getColor());
            System.out.println("Modelo: " + car.getModel());
            System.out.println("Marca: " + car.getBrand());
            System.out.println("Año: " + car.getYear());
            System.out.println("Tipo combustible: " + car.getFuelType());
            System.out.println("Transmisión: " + car.getTransmission());
            System.out.println("Numero de puertas: " + car.getNumberDoors());
            System.out.println("Motor: " + car.getMotor());
            System.out.println("Kilometros: " + car.getLicencePlate());
            System.out.println("Foto: " + car.getPhoto());
            System.out.println("=======================");
        }
        
        System.out.println("*******************************");
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarClient carClient = new CarClient();

        boolean isRunning = true;
        
        while(isRunning) {
            
            System.out.println("------------------------------------------");
             
            System.out.println("Digite una opción: ");
            System.out.println("1. Nuevo carro");
            System.out.println("2. Listar carros");
            System.out.println("3. Salir");
            
            System.out.println("------------------------------------------");
            
            int option = sc.nextInt();
            
            switch(option) {
                case 1:
                    createCar(sc, carClient);
                    break;
                case 2:
                    getCars(carClient);
                    break;
                case 3:
                    System.out.println("Ha salido del sistema");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
            
        }

    }

}
