import java.util.Scanner;
import java.io.File;


public class MergeSortImplementation {

    // These are variables that will be used during the implementation
    private int[] newArray;
    private int[] tempArray;
    private int lengthOfArray;


    /**
     *
     * this is the main method
     * @param args
     */
    public static void main (String args[]) {


        int[] data = readFiles("C:\\Users\\olivier\\IdeaProjects\\GCD\\src\\File3.txt");
        MergeSortImplementation mms = new MergeSortImplementation();
        mms.sort(data);

        // start time stamp of the forloop printing the sorted array
        long start = System.currentTimeMillis();

        for (int i : data) {
            System.out.print(i);
            System.out.print(", ");



        }
        // end time stamp of the forloop printing the sorted array

        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(start);
        double total  = (double)(end -start)/1000;
        System.out.println("Total time = "+total+"s");



    }

    /**
     *
     * this method reads the array text file from the local computer
     *
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

    /**
     *
     *
     * @param data
     */
        public void sort( int[] data) {

            this.newArray = data;
            this.lengthOfArray = data.length;
            this.tempArray = new int[lengthOfArray];
            doMergeSort(0,lengthOfArray -1 );
        }


    /**
     *
     * this method is used to merge the temporary subarrays back into one sorted array
     * @param lowerIndex
     * @param higherIndex
     */
    public void doMergeSort(int lowerIndex, int higherIndex){

            if (lowerIndex < higherIndex){

                int middle = lowerIndex +(higherIndex - lowerIndex) / 2;
                doMergeSort(lowerIndex, middle);
                doMergeSort(middle +1, higherIndex);
                mergeMethod(lowerIndex, middle, higherIndex);



            }
        }

    /**
     *
     * this method divides the input array into two halves
     * by finding the middle point of the array (int middle)
     * it createds temporary arrays temArray and newArray;
     * @param lowerIndex
     * @param middle
     * @param higherIndex
     */

        public void mergeMethod(int lowerIndex,int middle,int higherIndex){
            for (int i = lowerIndex; i <= higherIndex; i++){
                tempArray[i] = newArray[i];

            }
            int i = lowerIndex;
            int j = middle +1;
            int k = lowerIndex;
            while (i <= middle && j<= higherIndex){

                if(tempArray[i] <= tempArray[j]) {
                        newArray[k] = tempArray[i];
                        i++;
                }
                else {
                    newArray[k] = tempArray[j];
                    j++;
                }
                k++;
            }
            while (i <= middle) {
                newArray[k] = tempArray[i];
                k++;
                i++;
            }




        }


}
