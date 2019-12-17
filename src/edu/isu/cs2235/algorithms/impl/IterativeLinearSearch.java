package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

public class IterativeLinearSearch implements ArraySearch {

    public <E extends Comparable> int search(E[] array, E item){
        if (array == null)
            return -1;
        if (array.length == 0)
            return -1;
        if(item == null)
            return -1;
        for(int i = 0; i < array.length; i++){
            if (array[i] == item)
                return i;
        }
        return -1;
    }
}
