package com.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ScannerTest {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new FileReader("d:\\in3.txt")));
//        scanner.useDelimiter(",");
        scanner.useLocale(Locale.ENGLISH);
        Map<String,Integer> list = new HashMap<>();
        int counter =0;
        String word =null;
        while (scanner.hasNext()) {

               word = scanner.next();
            if (list.containsKey(word)){
                counter =list.get(word);
                counter++;
                list.put(word,counter);
            }else {
                list.put(word, 1);
            }
        }

        scanner.close();
//        System.out.println(list);

        for (Map.Entry<String, Integer> map : list.entrySet()) {
            map.getKey();
            if (counter>3) {
                map.getValue();
            }





        }
    }

}