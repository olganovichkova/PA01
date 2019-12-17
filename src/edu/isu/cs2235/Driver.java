package edu.isu.cs2235;

import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;




public class Driver {

    public static final int MAX_VALUE = 3000;
    public static final int MIN_ARRAY_LENGTH = 2000;
    public static final int INCREMENT = 100;
    public static final int STEP_COUNT = 10;
    public static final int RUN_COUNT = 2000;


    public static long[] iterLin = new long[STEP_COUNT];
    public static long[] recLin = new long[STEP_COUNT];
    public static long[] iterBin = new long[STEP_COUNT];
    public static long[] recBin = new long[STEP_COUNT];
    public static int[] lengthArray = new int[STEP_COUNT];


    public static Random random = new Random();


    public static void simulateSearch(){
        for(int i = 0; i < STEP_COUNT; i++){
            int length = MIN_ARRAY_LENGTH + (i * INCREMENT);
            System.out.println("Doing length = " + length);


            lengthArray[i] = length;
            iterLin[i] = 0;
            recLin[i] = 0;
            iterBin[i] = 0;
            recBin[i] = 0;
            for(int j = 0; j < RUN_COUNT; j++){
                int[] array = createArray(length);
                int value = randomInt();
                long timeStart;
                long timeFinish;
                timeStart = System.nanoTime();
                iterativeLinearSearch(array, value);
                timeFinish = System.nanoTime();
                iterLin[i] += timeFinish - timeStart;

                timeStart = System.nanoTime();
                recursiveLinearSearch(array, value);
                timeFinish = System.nanoTime();
                recLin[i] += timeFinish - timeStart;

                timeStart = System.nanoTime();
                iterativeBinarySearch(array, value);
                timeFinish = System.nanoTime();
                iterBin[i] += timeFinish - timeStart;

                timeStart = System.nanoTime();
                recursiveBinarySearch(array, value);
                timeFinish = System.nanoTime();
                recBin[i] += timeFinish - timeStart;
            }
            iterLin[i] /= RUN_COUNT;
            recLin[i]  /= RUN_COUNT;
            iterBin[i] /= RUN_COUNT;
            recBin[i]  /= RUN_COUNT;
        }
    }

    public static void printSimulations(){
        System.out.println("N\titerLin\trecLin\titerBin\trecBin");
        for(int i = 0; i < STEP_COUNT; i++){
           System.out.println("" + lengthArray[i] + "\t" +
                   iterLin[i] + "\t" +
                   recLin[i] +  "\t" +
                   iterBin[i] + "  \t" +
                   recBin[i]);
        }

    }

    public static void saveSimulations() {
        String fileName = "searchSimulator.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("N,iterLin,recLin,iterBin,recBin\n");
            for(int i = 0 ; i < STEP_COUNT; i++) {
                bw.write("" + lengthArray[i]
                        + "," + iterLin[i]
                        + "," + recLin[i]
                        + "," + iterBin[i]
                        + "," + recBin[i]
                        + "\n"
                );
            }
            bw.flush();
            bw.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    public static int iterativeLinearSearch(int[] array, int value) {

        for(int i = 0; i < array.length; i++){
            if (array[i] == value)
                return i;
        }
        return -1;
    }


    public static int recursiveLinearSearch(int[] array, int value) {

        int index = helperLinearSearch(array, value, 0);
        return index;
    }

    public static int helperLinearSearch(int[] array, int value, int i){
        if (i >= array.length)
            return -1;
        if (array[i] == value)
            return i;
        return helperLinearSearch(array, value, i + 1);
    }

    public static int iterativeBinarySearch(int[]array, int value) {
        int low = 0;
        int high = array.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value)
                return mid;
            if (value < array[mid])
                high = mid - 1;
            if (value > array[mid])
                low = mid + 1 ;


        }
        return -1;

    }

    public static int recursiveBinarySearch(int[] array, int value){
        int index = helperBinarySearch(array, value, 0, array.length - 1);
        return index;

    }

    public static int helperBinarySearch(int[] array, int value, int low, int high){
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (array[mid] == value)
            return mid;
        if (value < array[mid])
            high = mid - 1;
        if (value > array[mid])
            low = mid + 1;
        return helperBinarySearch(array, value, low, high);
    }



    public static int[] createArray(int size){
        int[] array = new int[size];
        for(int i = 0; i < size; i++)
            array[i] = random.nextInt(MAX_VALUE);
        Arrays.sort(array);
        return array;
    }

    public static int randomInt(){
        return random.nextInt(MAX_VALUE);
    }




    public static void main(String[] args) {

        simulateSearch();
        printSimulations();
        saveSimulations();


//        System.out.println("Hello");
//        long t0 = System.currentTimeMillis();
//        System.out.println("t0 =" + t0);
//        int[] array = new int[]{1,3,4,8,9,12,15};
//        int indexI = iterativeLinearSearch(array, 5);
//        System.out.println("(Iterative)Index of value = " + indexI);
//        int indexR = helperLinearSearch(array, 1, 5);
//        System.out.println("(Recursive)Index of value = " + indexR);
//        int indexIB = iterativeBinarySearch(array, 5);
//        System.out.println("(Iterative)Index of value = " + indexIB);
//        int indexRB = recursiveBinarySearch(array, 15);
//        System.out.println("(Recursive)Index of value = " + indexRB);
//        long t1 = System.currentTimeMillis();
//        long time = t1 - t0;
//        System.out.println("t1 = " + t1);
//        System.out.println("Time difference = " + time);
//        int[] a = createArray(100);
//        System.out.print("Array: ");
//        for(int val: a)
//            System.out.print(val + ", ");
    }



}
