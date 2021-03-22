import java.util.Scanner;
import java.io.File;

public class HeapSort {

    private static int tempInteger;


    /**
     *
     * this method takes in the input array
     * it extract the root and replace it with the last element in the array
     *  To heapify a subtree rooted with node i which is
     *  an index in arr[]. n is size of heap
     * @param data
     * @param size
     * @param i
     */
    public static void buildHeap(int data[], int size, int i) {
        // set largest as root
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && data[left] > data[largest]) {

            largest = left;
        }
        if (right < size && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != i) {
            tempInteger = data[i];
            data[i] = data[largest];
            data[largest] = tempInteger;
            buildHeap(data, size, largest);

        }
    }


    /**
     *
     * method to read the array textfile from my local computer
     * @param file
     * @return
     */
    public static int[] readFiles(String file) {

        try {

            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            int[] arr = new int[ctr];

            Scanner s1 = new Scanner(f);
            for (int i = 0; i < arr.length; i++)
                arr[i] = s1.nextInt();

            return arr;
        } catch (Exception E) {
            return null;
        }


    }


    /**
     * this method sorts the heap
     * @param data
     * @param size
     */

        public static void doHeapSort ( int data[], int size){

            int i;

            //Build heap (rearrange array)
            for (i = size / 2 - 1; i >= 0; i--)
                buildHeap(data, size, i);
            for (i = size - 1; i >= 0; i--) {

                tempInteger = data[0];
                data[0] = data[i];
                data[i] = tempInteger;
                buildHeap(data, i, 0);
            }
        }


    /**
     *
     * this is the main method
     * @param args
     */
    public static void main(String args[]) {

        int[] data = readFiles("C:\\Users\\olivier\\IdeaProjects\\GCD\\src\\File2.txt");
        // HeapSort mms = new HeapSort();
        int i;
        int size = data.length / data[0], length;

        long start = System.currentTimeMillis ();

        for (i = 0 ; i< size; i++) {

            doHeapSort(data, size);


            System.out.print(data[i]);
            System.out.print(", ");
        }
        long end = System.currentTimeMillis();

        System.out.println(start);
        System.out.println(end);
        double total = (double)(end - start)/ 1000;
        System.out.println("Total time =" +total+"s");




    }







}

