package com.solvd.CarService.threads;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class MyRunnableThread implements Runnable{

    @Override
    public void run(){
        int cont = 0;
        while (cont < 10){
            try {
                sleep(1000);
                System.out.println("Hello from "+ currentThread().getName());
                cont++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
