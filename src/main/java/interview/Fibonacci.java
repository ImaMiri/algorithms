package interview;

/**
 * Created by ima on 6/12/18.
 */
public class Fibonacci {

    public int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int topDownFibo(int n){
        return fibo(n, new int[n + 1]);
    }

    public int fibo(int n, int[] memo){
        if(n==0) return 0;
        if(n==1) return 1;
        if(memo[n] == 0)
            return fibo(n-1, memo) + fibo(n-2, memo);
        return memo[n];
    }

    public int bottomUpFibo(int n){
        if(n==0) return 0;
        else if(n==1) return 1;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n-1] + memo[n-2];
    }
}
