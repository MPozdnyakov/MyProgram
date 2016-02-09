package ThreadsTeast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mike on 2/8/2016.
 */
public class ThreadsTest {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        ConcurrentHashMap<String, Integer> wordMap = new ConcurrentHashMap<>();

        myScannerThread scannerThread = new myScannerThread("d:\\in3.txt", wordMap);
        Thread thread = new Thread(scannerThread);
        thread.start();
        thread.join();

        myScannerThread scannerThread2 = new myScannerThread("d:\\in4.txt",wordMap);
        Thread thread2 = new Thread(scannerThread);
        thread2.start();
        thread.join();

        myScannerThread scannerThread3 = new myScannerThread("d:\\in5.txt",wordMap);
        Thread thread3 = new Thread(scannerThread);
        thread3.start();
        thread.join();

        for (ConcurrentHashMap.Entry<String, Integer> map : wordMap.entrySet()) {

            if (map.getValue() > 3) {
                System.out.println(map.getKey());
            }


        }

    }
}

class myScannerThread implements Runnable {
    Scanner scanner;
    String fileLocation;
    ConcurrentHashMap<String, Integer> wordMap = null;

    public myScannerThread(String fileLocation, ConcurrentHashMap<String, Integer> wordMap) {

        this.fileLocation = fileLocation;
        this.wordMap = wordMap;
    }

    public void run() {


        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileLocation)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useLocale(Locale.ENGLISH);

        int counter = 0;

        while (scanner.hasNext()) {

            String word = scanner.next();
            if (wordMap.containsKey(word)) {
                counter = wordMap.get(word);
                counter++;
                wordMap.put(word, counter);
            } else {
                wordMap.put(word, 1);
            }
        }

        scanner.close();


    }
}






