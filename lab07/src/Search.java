//Joaquin Hidalgo
//CS 2401 | lab 07

import java.util.Arrays;
import java.util.Random;

public class Search {
    //Gets random position within the array
    //Parameter: length of array
    //Returns integer within the array
    public static int generateRandomPostion(int length) {
        Random rand = new Random();
        int result = rand.nextInt(length-1);
        return result;
    }

    //Generates ordered array of given length
    //Parameter: length of the array
    //Returns: array (sorted)
    public static double[] generateOrderedArray(int length) {
        Random rand = new Random();
        double[] arr = new double[length];

        for (int i =0; i< length; i++) {
            double temp = rand.nextDouble();
            // picks values from 0 to 100
            temp = temp*100;
            arr[i] = temp;
        }
        Arrays.sort(arr);
        return arr;
    }

    //Linear search
    //Parameter: array and postion "Key"
    //Return: index of key in the array
    public static int linearSearch(double[] arr, int pos) {
        for (int i =0; i< arr.length;i++) {
            if (arr[i] == arr[pos]) {
                return i;
            }
        }
        return -1;
    }

    //Binary search
    //Parameter: array and postion "Key"
    //Return: index of key in the array
    public static int binarySearch(double[] arr, int pos) {
        int low = 0;
        int high = arr.length -1;
        int index = -1;
        double key = arr[pos];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    //Generate 30 time stamps of the array
    //Parameter: array length desired
    //Return: array of 30 time stamps in "LinearSearch"
    public static long[] generateLinearTime(int length) {
        long[] linearTime = new long[30];
        for (int i = 0; i< 30; i++) {

            double[] array1 = generateOrderedArray(length);
            int position1 = generateRandomPostion(length);

            long startTimeLinear = System.nanoTime();
            linearSearch(array1, position1);
            long endTimeLinear = System.nanoTime();

            linearTime[i] = endTimeLinear - startTimeLinear;
        }
        return linearTime;
    }

    //Generate 30 time stamps of the array
    //Parameter: array length desired
    //Return: array of 30 time stamps in "BinarySearch"
    public static long[] generateBinaryTime(int length) {
        long[] binaryTime = new long[30];
        
        for (int i = 0; i< 30; i++) {
            double[] array1 = generateOrderedArray(length);
            int position1 = generateRandomPostion(length);
            long startTimeBinary = System.nanoTime();
            binarySearch(array1, position1);
            long endTimeBinary = System.nanoTime();
            binaryTime[i] = endTimeBinary - startTimeBinary ;
        }
        return binaryTime;
    }

    //gets average of array
    //Parameter: array of time stamps
    //Return: average of array
    public static long getAverage(long[] arr) {
        long sum = 0;
        for (int i =0; i< arr.length;i++) {
            sum+= arr[i];
        }
        long avg = sum / (long)arr.length;
        return avg;
    }

    public static void main(String[] args) {
        System.out.println("\nArray size\t| linear average(nanoSeconds)\t| binary average(nanoSeconds)");
        //Here now we have two arrays, length of 10,000 that has 30 time trials each
        long[] timeTrailLinear1 = generateLinearTime(10000);
        long[] timeTrailBinary1 = generateBinaryTime(10000);

        //Here now we have the average run-time
        System.out.println("10000\t\t| " +  getAverage(timeTrailLinear1) + "\t\t\t\t| " + getAverage(timeTrailBinary1) ) ;
        //Here now we have two arrays, length of 40,000 that has 30 time trials each
        long[] timeTrailLinear2 = generateLinearTime(40000);
        long[] timeTrailBinary2 = generateBinaryTime(40000);

        //Here now we have the average run-time
        System.out.println("40000\t\t| " +  getAverage(timeTrailLinear2) + "\t\t\t\t| " + getAverage(timeTrailBinary2) ) ;
        //Here now we have two arrays, length of 160,000 that has 30 time trials each
        long[] timeTrailLinear3 = generateLinearTime(160000);
        long[] timeTrailBinary3 = generateBinaryTime(160000);
        
        //Here now we have the average run-time
        System.out.println("160000\t\t| " +  getAverage(timeTrailLinear3) + "\t\t\t\t| " + getAverage(timeTrailBinary3) ) ;
        //Here now we have two arrays, length of 640,000 that has 30 time trials each
        long[] timeTrailLinear4 = generateLinearTime(640000);
        long[] timeTrailBinary4 = generateBinaryTime(640000);

        //Here now we have the average run-time
        System.out.println("640000\t\t| " +  getAverage(timeTrailLinear4) + "\t\t\t| " + getAverage(timeTrailBinary4) ) ;
        //Here now we have two arrays, length of 1,280,000 that has 30 time trials each
        long[] timeTrailLinear5 = generateLinearTime(1280000);
        long[] timeTrailBinary5 = generateBinaryTime(1280000);

        //Here now we have the average run-time
        System.out.println("1280000\t\t| " +  getAverage(timeTrailLinear5) + "\t\t\t| " + getAverage(timeTrailBinary5) ) ;
    }
}