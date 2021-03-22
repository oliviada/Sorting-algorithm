import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class SelectionSort {
    public static void main(String args[]) {


        int[] data = readFiles("C:\\Users\\olivier\\IdeaProjects\\GCD\\src\\File3.txt");
        //System.out.println(Arrays.toString(data));

        int[] arr2 = doSelectionSort(data);

       long start = System.currentTimeMillis();
        for (int i: arr2){
            System.out.print(i);
            System.out.print(",");

        }
        

        // this is the method I used to calculate the elapsed time of the operations
        // it returns the current time in milliseconds

        long end = System.currentTimeMillis();

        System.out.println(start);
        System.out.println(end);
        double total = (double)(end - start)/1000;
        System.out.println("Total time = "+total+"s");



    }



    // this methods reads the array text file
        public static int[] readFiles(String file){

            try{

                File f = new File(file);
                Scanner s = new Scanner(f);
                int ctr = 0;
                while (s.hasNextInt()) {
                    ctr++;
                    s.nextInt();
                }
                int[] arr = new int[ctr];

                Scanner s1 = new Scanner(f);
                for (int i= 0; i< arr.length; i++)
                    arr[i] = s1.nextInt();

                return arr;
            }
            catch (Exception E) {
                return null;
            }


    }



    public static int [] doSelectionSort(int[] arr) {

        for(int i = 0 ; i < arr.length  - 1; i++){

            int index= i;

            for (int j = i + 1; j < arr.length; j++)

                if (arr[j] < arr[index])
                    index = j;

                int smallerNumber = arr[index];
                arr[index] = arr[i];
                arr[i] = smallerNumber;

            }
        return arr;

        }

    }

