package com.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 1/12/2016.
 */
public class App {
    public static void main(String[] args) {
        Animal bob = new Dog(1, 10, 20, "white", "Bob", "Buldog", true, true);
        Animal bob1 = new Dog(1, 10, 20, "white", "Bob", "Buldog", true, true);
        Animal bob2 = new Dog(1, 10, 20, "black", "Bob","Buldog", true, true);
        // bob.voice();
//        System.out.println();
        Cat puss = new Cat(2, 10, 20, "gray", "Barsik","Pers", true);
//        puss.voice();
//        System.out.println();
        Wild giraffe = new Wild(3, 5, 100, "green","Giraff", false);
//        giraffe.voice();
//        System.out.println();
        Wild croc = new Wild(4, 5, 100, "green","Alligator", true);
//        croc.voice();
//        System.out.println();
//        Fish nemo=new Fish(1,2,3,"gold","Nemo",true);
//        nemo.voice();
        Map <Animal,Animal> zoo = new HashMap();

        for (int i =0; i<1000; i++){
            Animal bob3 = new Dog(i, i, i, "black", "Bob","Buldog", true, true);

        zoo.put(bob3,bob3);
        }
       double start = System.currentTimeMillis();
        zoo.get(bob3).voice();
        double stop = System.currentTimeMillis();


        System.out.println(start-stop);
//        List<Animal> arr = new ArrayList();
//        arr.add(bob);
//        arr.add(puss);
//        arr.add(giraffe);
//
//        for (Animal item:arr) {
//            item.voice();
//        }



    }

}
