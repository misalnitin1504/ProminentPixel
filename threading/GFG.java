package com.prominentpixel.threading;

public class GFG {


    // Starting counter
    int counter = 1;

    static int N=10;

    // Function to print odd numbers
    public void printOddNumber() {
        synchronized (this) {
            // Print number till the N
            while (counter < N) {

                // If count is even then print
                while (counter % 2 == 0) {

                    // Exception handle
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.print(counter + " ");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){e.printStackTrace();}

                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }
    }

    // Function to print even numbers
    public void printEvenNumber() {
        synchronized (this) {
            // Print number till the N
            while (counter < N) {

                // If count is odd then print
                while (counter % 2 == 1) {

                    // Exception handle
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.print(
                        counter + " ");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){e.printStackTrace();}


                // Increment counter
                counter++;

                // Notify to 2nd thread
                notify();
            }
        }
    }
}
