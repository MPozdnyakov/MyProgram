package com.OOP;

/**
 * Created by Mike on 1/31/2016.
 */
public class GenericsApp {

    public static void main(String[] args) {
        int arrayLength = 6;
        int array[] = new int[arrayLength];

            array[0] = 1;
        array[1] = 2;
        array[2] = 6;
        array[3] = 7;
        array[4] = 8;
        array[5] = 10;

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("--------");
        twoDigitsFinder(array, 6);
    }

    public static void twoDigitsFinder(int[] array, int N)
    {

        int firstNumber = array[0];
        int secondNumber = array[array.length-1];
        for (int i = 0; i < array.length; i++) {
            if (checkFirstAndLastNumbers(firstNumber, secondNumber,N)) {
                System.out.print("first number " + " " + firstNumber + " " + "second number = " + secondNumber);
                return;
            }
            if ((firstNumber+secondNumber!=N)&&(i==array.length-1)){
                System.out.println("There are no such numbers");
            }
            if (checkIfReceivedNumberIsBigger(array,N)||checkIfReceivedNumberIsSmaller(array,N)){
                System.out.println("There are no such numbers");
                return;
            }else if (N > array[array.length-1]) {

                firstNumber = array[i + 1];
            } else {
                secondNumber = array[array.length-1]-i;
            }
        }
    }
    public static boolean checkIfReceivedNumberIsBigger(int array[], int N){
        return((array.length + (array.length - 1) < N));
    }
    public static boolean checkIfReceivedNumberIsSmaller(int array[], int N){
        return((array[0] + array[1]) > N);
    }
    public static boolean checkFirstAndLastNumbers(int firstNumber,int secondNumber, int N){

        return (firstNumber + secondNumber == N);
    }
}