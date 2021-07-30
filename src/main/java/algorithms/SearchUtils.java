package algorithms;

/**
 * Created on 9/06/2016.
 *
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public class SearchUtils {

    /**
     * Simple Linear Search
     * Complexity of the algorithm
     * Best: O(1)
     * Worst: O(n)
     */
    public static int linearSearch(int[] array, int val){

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if(val == num){
                return i;
            }
        }

        return -1;
    }

    /**
     * Array should be sorted asc
     * The implementation is not recursive
     * Complexity of the algorithm
     * Best: O(1)
     * Worst: O(logn)
     */
    public static int binarySearch(int[] array, int val){
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            int mid = (high + low) / 2;
            if(array[mid] == val)
                return mid;
            else if(array[mid] < val)
                low = mid +1;
            else
                high = mid - 1;
        }
        return -1;
    }

    /**
     * Array should be sorted asc
     * The implementation is recursive
     * Complexity of the algorithm
     * Best: O(1)
     * Worst: O(log n)
     */
    public static int binarySearchRecursive(int[] array, int val, int low, int high){
        int mid = (high + low) / 2;
        if(high < low)
            return -1;

        if(array[mid] == val)
            return mid;
        else if(array[mid] < val)
            return binarySearchRecursive(array, val,mid + 1, high);
        else
            return binarySearchRecursive(array,val,low ,mid - 1);
    }

}
