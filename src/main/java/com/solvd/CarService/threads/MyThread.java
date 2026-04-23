package com.solvd.CarService.threads;

public class MyThread extends Thread{

    @Override
    public void run(){
        int cont = 0;
        while (cont < 10){
            try {
                sleep(1000);
                System.out.println("Hello from "+ getName());
                cont++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
