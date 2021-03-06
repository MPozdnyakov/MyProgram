package ThreadsTeast;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mike on 2/8/2016.
 */
public class ThreadsTest {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        ConcurrentHashMap<String, Integer> wordMap = new ConcurrentHashMap<>();

        MyScannerThread scannerThread = new MyScannerThread("d:\\in3.txt", wordMap, "d:\\out3.txt");
        Thread thread = new Thread(scannerThread);
        thread.start();

        MyScannerThread scannerThread2 = new MyScannerThread("d:\\in4.txt", wordMap, "d:\\out4.txt");
        Thread thread2 = new Thread(scannerThread2);
        thread2.start();

        MyScannerThread scannerThread3 = new MyScannerThread("d:\\in5.txt", wordMap, "d:\\out5.txt");
        Thread thread3 = new Thread(scannerThread3);
        thread3.start();
        thread.join();
        thread2.join();
        thread3.join();


        for (ConcurrentHashMap.Entry<String, Integer> map : wordMap.entrySet()) {

            if (map.getValue() > 3) {
                System.out.println(map.getKey());
            }


        }

    }
}

class MyScannerThread implements Runnable {
    private String fileToRead;
    private String fileToWrite;
    ConcurrentHashMap<String, Integer> wordMap = null;

    public MyScannerThread(String fileToRead, ConcurrentHashMap<String, Integer> wordMap, String fileToWrite) {
        this.fileToWrite = fileToWrite;
        this.fileToRead = fileToRead;
        this.wordMap = wordMap;
    }

    @Override
    public void run() {
        Scanner scanner = null;
        FileWriter fileWriter = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileToRead)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fileWriter = new FileWriter(fileToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }


        reaDdFile(scanner, wordMap);
        try {
            writeFile(fileWriter, wordMap);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void reaDdFile(Scanner scanner, ConcurrentHashMap<String, Integer> wordMap) {
        int counter;

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

    private void writeFile(FileWriter fileWriter, ConcurrentHashMap<String, Integer> wordMap) throws IOException {

        for (ConcurrentHashMap.Entry<String, Integer> map : wordMap.entrySet()) {

            if (map.getValue() > 3) {

                fileWriter.write(map.getKey() + ", ");
            }
        }
        fileWriter.flush();
    }
}






