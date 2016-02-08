package com.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mike on 2/1/2016.
 */
public class CopyCharacters {


    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("d:\\in1.txt");
        FileWriter fileWriter = new FileWriter("d:\\out2.txt");

        int ch;
        while((ch = fileReader.read())!=-1) {
            System.out.print((char)ch);
            fileWriter.write(ch);
        }
        fileReader.close();
        fileWriter.flush();
    }
}
