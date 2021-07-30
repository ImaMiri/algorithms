package algorithms;


/**
 * Created by fmiri on 9/06/2016.
 *
 * @author Ima Miri <fmiri@ebay.com>
 */
public class SortUtils {

    /*
     * Time complexity O(n^2)
     */
    public static void bubbleSort(int[] array){
        int temp;

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        int min;
        for(int i=0; i<arr.length; i++){
            min = i;
            for(int j=0; j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp;
            temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }

   public static void quickSort(int[] arr, int left, int right){
        int index = partition(arr, left, right);
        if(left < index - 1){
            quickSort(arr, left, index - 1);
        }
        if(index < right){
            quickSort(arr, index, right);
        }
   }

   private static int partition(int[]arr, int left, int right){
       int pivot = arr[(left+right)/2];
       while(left <= right){
           while (arr[left]<pivot) left++;
           while (arr[right] > pivot) right--;
           if(left<=right){
               swap(arr, left, right);
               left++;
               right--;
           }
       }
       return left;
   }

    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void mergeSort(int[] arr){
        // create a helper array with the same size as original array
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(arr, helper, low, mid);
            mergeSort(arr, helper, mid + 1, high);
            merge(arr, helper, low, mid, high);
        }
    }

    private static void merge(int[] arr, int[]helper, int low, int mid, int high){
        // copy both halves into the helper array
        for(int i=low; i<= high; i++){
            helper[i] = arr[i];
        }

        // Iterate through the helper array to compare left and right hand. Copying the smaller element from the two halves into the original array
        int helperLeft= low;
        int helperRight = mid + 1;
        int curr = low;
        while(helperLeft <= mid && helperRight <= high) {
            if(helper[helperLeft] <= helper[helperRight]){
                arr[curr] = helper[helperLeft];
                helperLeft++;
            }else{
                arr[curr] = helper[helperRight];
                helperRight++;
            }
            curr++;
        }

        // copy the remaining elements
        int rem = mid - helperLeft;
        for(int i = 0; i <= rem; i++){
            arr[curr +i] = helper[helperLeft+i];
        }
    }

    public static void radixSort() {

    }
}
