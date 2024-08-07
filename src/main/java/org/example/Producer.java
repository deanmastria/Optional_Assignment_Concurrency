package org.example;

import java.util.Random;


public class Producer implements Runnable {
    private final SharedBuffer sharedBuffer;                            //Reference to the shared buffer
    private final Random random;                                        //Random number Generator
    private volatile boolean running = true;                            //Boolean Flag to control loop

    //Constructor to initialize the shared buffer reference and random number generator
    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;                               //Initialize the shared buffer reference
        this.random = new Random();                                     //Initialize the random number generator
    }

    //Method executed when thread starts
    @Override
    public void run() {
        while (running) {
            try {
                int value = random.nextInt(100);                //Geneerate a random number between 0- 100
                sharedBuffer.add(value);                               //add the generate number to the buffer
                System.out.printf("Produced %d\n", value);             //
                Thread.sleep(100);                               //Slepp 100 ms to sim pruction delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;                                                 //Exit the loop if interrupted
            }
        }
    }

    //Method for stopping thread
    public void stop() {
        running = false;                                                   //Flag set to false to exit loop
    }
}
