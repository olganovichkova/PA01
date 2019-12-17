package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

public class RecursiveLinearSearch implements ArraySearch {

    public <E extends Comparable> int search(E[] array, E item){

        if (array == null)
            return -1;
        if (array.length == 0)
            return -1;
        if(item == null)
            return -1;
        int index = helperLinearSearch(array, item, 0);
        return index;
    }

    public <E extends Comparable> int helperLinearSearch(E [] array, E item, int i) {
        if (i >= array.length)
            return -1;
        if (array[i] == item)
            return i;
        return helperLinearSearch(array, item, i + 1);
    }

}

