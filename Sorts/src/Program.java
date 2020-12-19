import sort.Sort;

public class Program {


    public static void main(String[] args) {

        int[] arr = {10,9,8,7,6,5,3,4,1,2,0};
        // Sort.bubbleSort(arr);
        //Sort.selectionSort(arr);
        //Sort.insertionSort(arr);
        //Sort.shellSort(arr);
        //Sort.heapSort(arr);
        //Sort.quickSort(arr);
        Sort.mergeSort(arr);
        printArray(arr);

    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }


}
