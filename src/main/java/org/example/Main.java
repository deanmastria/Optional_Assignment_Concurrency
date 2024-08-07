package org.example;

import javax.sound.midi.Soundbank;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(10);       //Created Shared Buffer with a max size of 10

        Producer producer = new Producer(sharedBuffer);                 //Created producer with the shared buffer
        Consumer consumer = new Consumer(sharedBuffer);                 //Created consumer with the shared buffer

        Thread producerThread = new Thread(producer);                   //Created thread to producer
        Thread consumerThread = new Thread(consumer);                   // Created thread for consumer

        producerThread.start();                                         //Starts producer thread
        consumerThread.start();                                         //Starts consumer thread

        try {
            Thread.sleep(10000);                                     //Runs threads for 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();                         //Restore interrupted status
        }

        //Stops threads
        producer.stop();
        consumer.stop();

        //Waits for threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Exiting Thread");

    }
}