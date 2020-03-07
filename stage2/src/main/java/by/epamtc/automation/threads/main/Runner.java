package by.epamtc.automation.threads.main;

import java.util.concurrent.Semaphore;

public class Runner {

    private static  final int NUMBER_PARKING_PLACES = 4;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(NUMBER_PARKING_PLACES);
        new Car(semaphore, "Nissan Leaf").start();
        new Car(semaphore, "Mini One").start();
        new Car(semaphore, "Tesla Cybertrack").start();
        new Car(semaphore, "Mazda 6").start();
        new Car(semaphore, "Volkswagen Golf").start();
        new Car(semaphore, "Chevrolet Volt").start();
        new Car(semaphore, "BMW i3").start();
        new Car(semaphore, "Audi Q5").start();
    }
}
