package com.password;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This file is used to demonstrate the use of ValidatePassword class.
 */

public class invalidTextFilePassword {

    private static String inputURLPath = "./src/main/resources/input.txt";
    private static String outputURLPath = "./src/main/resources/output.txt";

    public static void main(String[] args) {

        // Create a new thread to handle this file.
        // TODO: Multiple threads can be created to handle load accordingly. For a large number of threads, threadpool can be implemented.

        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                // Make instance of the ValidatePassword class.
                ValidatePassword inputPassword = new ValidatePassword();
                try {
                    // Open the input file
                    FileReader inputFile = new FileReader(inputURLPath);
                    // Check if the input file contains invalid password. outputList contains invalid passwords along with their reason.
                    ArrayList<String> outputList = inputPassword.isValidPassword(inputFile);

                    // Create an output stream to write to a file.
                    FileOutputStream outputStream = new FileOutputStream(outputURLPath);

                    // Write the contents of the outputList to the file.
                    for(String s: outputList) {
                        outputStream.write(s.getBytes());
                    }

                    // Close output file.
                    outputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
    }
}
