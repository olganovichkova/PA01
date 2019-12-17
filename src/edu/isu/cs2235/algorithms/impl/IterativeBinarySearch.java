package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

public class IterativeBinarySearch implements ArraySearch {

    public <E extends Comparable> int search(E[] array, E item){

        if (array == null)
            return -1;
        if (array.length == 0)
            return -1;
        if(item == null)
            return -1;

        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == item)
                return mid;
            if (item.compareTo(array[mid]) < 0)
                high = mid - 1;
            if (item.compareTo(array[mid]) > 0)
                low = mid + 1 ;
        }
        return -1;
    }
}
