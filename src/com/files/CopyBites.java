package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Mike on 2/1/2016.
 */
public class CopyBites {

    public static void main(String[] args) throws IOException {
        File file = new File("d:\\in1.txt");
        byte[] array = readFromFile(file);
        for (byte b : array) {
            System.out.println(b);
        }
    }

    private static byte[] readFromFile(File file) {
        FileInputStream inputStream = null;
        try {
            inputStream=new FileInputStream(file);
            long file_length = file.length();
            byte[] array = new byte[(int) file_length];
            int value;
            int i = 0;
            while ((value = inputStream.read()) != -1) {
                array[i++] = (byte) value;
            }
            return array;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }
}