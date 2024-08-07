package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(10);       //Created Shared Buffer with a max size of 10

        Producer producer = new Producer(sharedBuffer);                 //Created producer with the shared buffer
        Consumer consumer = new Consumer(sharedBuffer);                 //Created consumer with the shared buffer

        producerThread.start();                                         //Starts producer thread
        consumerThread.start();                                         //Starts consumer thread

    }
}