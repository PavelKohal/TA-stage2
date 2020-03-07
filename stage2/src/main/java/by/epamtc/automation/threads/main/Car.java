package by.epamtc.automation.threads.main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {

    private Semaphore semaphore;
    private String carModel;
    private static final int MAX_WAITING_TIME = 5;

    public Car(Semaphore semaphore, String carModel) {
        this.semaphore = semaphore;
        this.carModel = carModel;
    }

    public void run() {
        System.out.println(carModel + " прибыл на паркинг и ищет свободное место...");

        try {
            if(semaphore.tryAcquire(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
                System.out.println(carModel + " паркуется на найденном свободном месте...");
                TimeUnit.SECONDS.sleep(2 + (int) (Math.random() * 6));
                System.out.println(carModel + " покидает паркинг после стоянки...");
                semaphore.release();
            } else {
                System.out.println(carModel + " не нашел место и уехал");
            }
        } catch(InterruptedException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

    }
}
