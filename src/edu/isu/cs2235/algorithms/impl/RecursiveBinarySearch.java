package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySearch;

public class RecursiveBinarySearch implements ArraySearch {

    public <E extends Comparable> int search(E[] array, E item){

        if (array == null)
            return -1;
        if (array.length == 0)
            return -1;
        if(item == null)
            return -1;

        int index = helperBinarySearch(array, item, 0, array.length - 1);
        return index;

    }

    public <E extends Comparable> int helperBinarySearch(E[] array, E value, int low, int high){
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (array[mid] == value)
            return mid;
        if (value.compareTo(array[mid]) < 0)
            high = mid - 1;
        if (value.compareTo(array[mid]) > 0)
            low = mid + 1;
        return helperBinarySearch(array, value, low, high);
    }
}

