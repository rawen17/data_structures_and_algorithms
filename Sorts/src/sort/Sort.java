package sort;

public class Sort {

    public static void bubbleSort(int[] arr) {
        int barrier;
        int index;
        boolean exchangeFlag;
        int tmp;

        for (barrier = arr.length - 1; barrier > 0; barrier--) {
            exchangeFlag = false;

            for (index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    // swap
                    tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                    // change flag
                    exchangeFlag = true;
                }
            }
            // check flag
            if (!exchangeFlag) {
                return;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int i , j;
        int indexMin;
        int tmp;
        for (i = 0; i < arr.length - 1; i++) {
            indexMin = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                // swap
                tmp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int i, j, k;
        int indexToChange;
        int tmp;
        for (i = 1; i < arr.length; i++) {
            indexToChange = i;

            for (j = i - 1; j >= 0 && (arr[j] > arr[i]); j--) {
                indexToChange = j;
            }

            if (indexToChange != i) {
                tmp = arr[i];
                for (k = i - 1; k >= indexToChange; k--) {
                    arr[k + 1] = arr[k];
                }
                arr[indexToChange] = tmp;
            }
        }
    }

    public static void shellSort(int[] arr) {
        int i, j;
        int tmp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (i = gap; i < arr.length; i++) {
                for (j = i; j - gap >= 0; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        tmp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = tmp;
                    }
                }
            }
        }
    }


    public static void heapSort(int[] arr) {
        for (int startIndex = (arr.length / 2) - 1; startIndex >= 0; startIndex--) {
            Down(arr, startIndex, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            Down(arr, 0, i);
        }
    }

    public static void Down(int[] arr, int root, int size) {
        int rootIndex = root;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = leftIndex + 1;

        if (leftIndex < size && arr[leftIndex] > arr[rootIndex]) {
            rootIndex = leftIndex;
        }
        if (rightIndex < size && arr[rightIndex] > arr[rootIndex]) {
            rootIndex = rightIndex;
        }
        if (rootIndex == root) {
            return;
        }

        int tmp = arr[root];
        arr[root] = arr[rootIndex];
        arr[rootIndex] = tmp;

        Down(arr, rootIndex, size);
    }

    public static void quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int pivot = arr[rightIndex];
        int lastLowerIndex = leftIndex - 1;
        int tmp;

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (arr[i] <= pivot) {
                tmp = arr[i];
                arr[i] = arr[lastLowerIndex + 1];
                arr[lastLowerIndex + 1] = tmp;
                lastLowerIndex++;
            }
        }

        partition(arr, leftIndex, lastLowerIndex - 1);
        partition(arr, lastLowerIndex + 1, rightIndex);
    }

    public static void mergeSort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int center = leftIndex + ((rightIndex - leftIndex) / 2) ;
        mergesort(arr, leftIndex, center);
        mergesort(arr, center + 1, rightIndex);
        merge(arr, leftIndex, center, rightIndex);
    }


    public static void merge(int[] arr, int leftIndex, int centerIndex, int rightIndex) {
        int[] result = new int[rightIndex - leftIndex + 1];

        int indexArr1 = leftIndex;
        int indexArr2 = centerIndex + 1;
        int index = 0;

        while (indexArr1 <= centerIndex && indexArr2 <= rightIndex) {
            if (arr[indexArr1] < arr[indexArr2]) {
                result[index] = arr[indexArr1];
                indexArr1++;
            } else {
                result[index] = arr[indexArr2];
                indexArr2++;
            }
            index++;
        }

        while (indexArr1 <= centerIndex) {
            result[index] = arr[indexArr1];
            indexArr1++;
            index++;
        }

        while (indexArr2 <= rightIndex) {
            result[index] = arr[indexArr2];
            indexArr2++;
            index++;
        }

        for (int i = leftIndex; i <= rightIndex; i++) {
            arr[i] = result[i - leftIndex];
        }
    }


    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
