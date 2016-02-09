package com.StreamTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Mike on 2/8/2016.
 */
public class AnnotationTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Printer pr = new Printer();
        CustomAnnotation annotation = pr.getClass().getAnnotation(CustomAnnotation.class);
        String method = annotation.methodToInvoke();
        int numberofTimes = annotation.numberofTimes();

        Method method1 = pr.getClass().getMethod(method, int.class);
        method1.invoke(pr, numberofTimes);

    }
}

@CustomAnnotation(numberofTimes = 5, methodToInvoke = "method1")
class Printer {
    public void method1(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Method 1: " + i);
        }
    }

    public void method2(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Method 2: " + i);
        }
    }
}

@interface CustomAnnotation {
    int numberofTimes();

    String methodToInvoke();


}
