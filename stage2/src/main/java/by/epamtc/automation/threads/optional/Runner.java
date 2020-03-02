package by.epamtc.automation.threads.optional;

import java.util.concurrent.Semaphore;

public class Runner {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        new Airplane(semaphore, "Boeing-737 - 0896").start();
        new Airplane(semaphore, "Boeing-747 - 0711").start();
        new Airplane(semaphore, "Airbus-A380 - 1122").start();
        new Airplane(semaphore, "Boeing-737 - 0830").start();
        new Airplane(semaphore, "Airbus-A340 - 0215").start();
        new Airplane(semaphore, "Airbus-A340 - 0389").start();
        new Airplane(semaphore, "Boeing-737 - 0777").start();
        new Airplane(semaphore, "Boeing-787 - 0965").start();
        new Airplane(semaphore, "Airbus-A380 - 0458").start();
        new Airplane(semaphore, "Airbus-A380 - 0985").start();
    }
}
