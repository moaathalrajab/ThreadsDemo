package com.example.demo;

public class SimpleThreads implements Runnable{

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + Thread.currentThread().getName() + " " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " exiting.");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SimpleThreads(), "First");
        Thread t2 = new Thread(new SimpleThreads(), "Second");
        t1.start();
        t2.start();
    }
}
