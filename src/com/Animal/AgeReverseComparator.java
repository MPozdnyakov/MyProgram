package com.Animal;

import java.util.Comparator;

/**
 * Created by Mike on 1/31/2016.
 */
public class AgeReverseComparator <T> implements Comparator<T>{
private Comparator comparator;
    public AgeReverseComparator(Comparator<T>   comparator){
        this.comparator=comparator;
    }

    @Override
    public int compare(T o1, T o2) {
        return comparator.compare(o1, o2);

    }
}
