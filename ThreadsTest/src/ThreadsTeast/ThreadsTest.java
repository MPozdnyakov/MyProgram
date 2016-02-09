package ThreadsTeast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Mike on 2/8/2016.
 */
public class ThreadsTest {
    public static void main(String[] args) throws FileNotFoundException {

        myScannerThread scannerThread = new myScannerThread("d:\\in3.txt");
        Thread thread = new Thread(scannerThread);
        thread.start();

//        myScannerThread scannerThread2 = new myScannerThread("d:\\in4.txt");
//        Thread thread2 = new Thread(scannerThread);
//        thread2.start();

//        myScannerThread scannerThread3 = new myScannerThread("d:\\in5.txt");
//        Thread thread3 = new Thread(scannerThread);
//        thread3.start();


    }
}

  class myScannerThread implements Runnable {
      Scanner scanner;
      String fileLocation;
      public myScannerThread(String fileLocation){

          this.fileLocation = fileLocation;
      }

     public void run() {



         try {
             scanner = new Scanner(new BufferedReader(new FileReader(fileLocation)));
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         scanner.useLocale(Locale.ENGLISH);
         Map<String, Integer> list = new HashMap<>();
         int counter = 0;

         while (scanner.hasNext()) {

             String word = scanner.next();
             if (list.containsKey(word)) {
                 counter = list.get(word);
                 counter++;
                 list.put(word, counter);
             } else {
                 list.put(word, 1);
             }
         }

         scanner.close();


         for (Map.Entry<String, Integer> map : list.entrySet()) {

             if (map.getValue() > 3) {
                 System.out.println(map.getKey());
             }


         }
     }
 }






