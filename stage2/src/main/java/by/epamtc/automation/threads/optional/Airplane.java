package by.epamtc.automation.threads.optional;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Airplane extends Thread {

    private Semaphore semaphore;
    private String boardName;

    public Airplane(Semaphore semaphore, String boardName) {
        this.semaphore = semaphore;
        this.boardName = boardName;
    }

    @Override
    public void run() {
        try {
            System.out.println(boardName + " начал выход на полосу.");
            semaphore.acquire();
            System.out.println("Полоса приняла " + boardName + ".");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(boardName + " взлетел.");
            semaphore.release();
            System.out.println("Полоса освободилась.");
        } catch(InterruptedException e) {
            System.out.println("Технические неполадки.");
        }
    }
}

