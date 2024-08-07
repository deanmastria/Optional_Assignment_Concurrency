package org.example;

public class Consumer implements Runnable {
    private final SharedBuffer sharedBuffer;                //Reference to the shared buffer
    private volatile boolean running = true;                //Boolean Flag to control loop

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;                   //Initializes the shared buffer reference
    }

    @Override
    public void run() {
        int sum = 0;                                        //Initialize the sum of consumed numebrs
        while (running) {                                      //Continuous consumption loop
            try {
                int value = sharedBuffer.remove();          //Remove Value from the buffer
                sum += value;                               //Add value to the sum
                System.out.println("Consumed " + value + " | Current Sum: " + sum);     //Print the consumed value and current sum
                Thread.sleep(150);                      //Sleep to simulate consumption delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();         //Restore interrupted status
            break;                                          //Exits loop if interrupted
            }
        }
    }

    //Method for stopping thread
    public void stop() {
        running = false;                                    //Flag set to false to exit loop
    }
}
