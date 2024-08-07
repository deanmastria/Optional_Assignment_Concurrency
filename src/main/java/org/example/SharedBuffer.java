package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer;                //Manages a queue to store integers.
    private final int maxSize;                          //Limits the maximum size of the buffer.

    public SharedBuffer(int maxSize) {
        this.buffer = new LinkedList<>();               //Initialize the buffer as a LinkedList
        this.maxSize = maxSize;                         //Set the max size for the buffer
    }

    //Synchronized add and remove methods to safely add and remove items from the buffer. Use wait() and notifyAll() to manage thread synchronization.
    public synchronized void add(int value) throws InterruptedException {
        while (buffer.size() >= maxSize) {
            wait();                                     //Wait if the buffer is full
        }
    buffer.add(value);                                  //Add the value to the buffer
        notifyAll();                                    //Notify all waiting threads
    }

    public synchronized int remove() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();                                    //Waits if buffer is empty

        }
        int value = buffer.remove();                    //Remove and return the value from the buffer
        notifyAll();                                    //Notify all waiting threads
        return value;
    }
}

