import java.util.Scanner;
import java.io.File;


public class InsertionSort {

    /**
     * this is my unit test method
     * it works fine, all you have to do is replace the file path to the right location of your computer
     * where all your array text files are saved.
     * @param args
     */

    public static void main(String args[]){

        // this set the array text file to a new array value of int call data
        // all you have to is change path in this readFiles method to the right location
        // where your array text file is saved in order run this
        int[] data = readFiles("C:\\Users\\olivier\\IdeaProjects\\GCD\\src\\File2.txt");

        int[] newArray = insertionSortMethod(data);

        // this gets the time stamp at the beginning of the forloop that prints the sorted array
        long start = System.currentTimeMillis();
        for (int i:newArray) {
            System.out.print(i);
            System.out.print(",");
        }
        // this is where my forloop ends and the long end value gets the time stamp as well
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
        double total = (double)(end - start) / 1000;
        System.out.println("Total time ="+total+"s");




    }


    /**
     * this method reads the array text file from my local computer
     * @param file
     * @return
     */
    public static int[] readFiles(String file){

        try{

            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            int[] input = new int[ctr];

            Scanner s1 = new Scanner(f);
            for (int i= 0; i< input.length; i++)
                input[i] = s1.nextInt();

            return input;
        }
        catch (Exception E) {
            return null;
        }


    }


    /**
     * this method sorts the array in a ascending order
     * it compares the current element key (int tempNumber) to its predecessor
     * it moves the key element iup to one position if it is smaller r than its predecessor and compares it
     * to the element before
     * @param input
     * @return
     */
    public static int[] insertionSortMethod(int [] input) {

        int tempNumber;
        for (int i = 1; i < input.length;i++){

            for (int j= i ; j>0 ; j--) {
                if(input[j] < input[j-1]) {
                    tempNumber = input[j];
                    input[j] = input[j-1];
                    input[j-1] = tempNumber;
                }



            }
        }
        return input;
    }
}

