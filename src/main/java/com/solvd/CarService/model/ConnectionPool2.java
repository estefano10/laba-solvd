package com.solvd.CarService.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool2 {
    private static final int size = 5;
    private final BlockingQueue<Connection> free = new LinkedBlockingQueue<>(size);

    public Connection acquire() throws InterruptedException{
        return free.take();
    }
    public void release(Connection c) throws InterruptedException{
        free.put(c);
    }
    public void shutdown(){
        for (Connection c : free){
            c.close();
            free.clear();
        }
    }
    private ConnectionPool2(){
        for (int i = 0; i < size; i++){
            Connection c = new Connection(i);
            c.open();
            free.offer(c);
        }
    }
    private static class Holder{
        static final ConnectionPool2 INSTANCE = new ConnectionPool2();
    }
    public static final ConnectionPool2 getInstance(){
        return Holder.INSTANCE;
    }
}
