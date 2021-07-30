import java.io.*;
import java.util.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        int numSocks = 1;
        int pairs = 0;

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){
                if(ar[i]== ar[j]){
                    numSocks++;
                }
                if(ar[i] != ar[j] || j==n-1){
                    i = j-1;
                    break;
                }
            }
            pairs += (numSocks/2);
            numSocks = 1;
        }

        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] ar = {1,1,3,1,2,1,3,3,3,3};

        int result = sockMerchant(ar.length, ar);

        System.out.println(result);
    }
}

