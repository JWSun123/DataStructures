package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FiboCache {
    private static List<Long> fibsCached = new ArrayList<>(); // NOT a HashMap !
    private static int fibsCompCount = 2;

    public FiboCache() {
        fibsCached.add(0L);
        fibsCached.add(1L);
    }

    public long getNthFib(int n) {
        if (n < 0){
            throw new IllegalArgumentException("Index can not be less than 1.");
        }
        if (n <= fibsCached.size()) {
            return fibsCached.get(n - 1); // n is the Nth number in the fibonacci series, so n starts with 1 (not 0).
        } else {
            long result = getNthFib(n - 1) + getNthFib(n - 2);
            fibsCached.add(result); // the result will be added in to the arraylist, because it doesn't exist yet.
            fibsCompCount++;
            return result;
        }
    }

    public int getCountOfFibsComputed() {
        return fibsCompCount;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("FiboCache：");
        for (int i = 0; i < fibsCached.size(); i++) {
            s.append(i == 0 ? "" : ", ");
            s.append(fibsCached.get(i));
        }
        return s.toString();
    }

    public long getNthFibNonRecursive(int n){
        n--;
        if (n < 0){
            throw new IllegalArgumentException("Index can not be less than 1.");
        }
        return computeNthFib(n);
    }

    private long computeNthFib(int n){
        // 1. try to take the values by key. if it returns then exit; if not, try to calculate and put in the data collection.
        // Redis
        for(int index = fibsCached.size(); index <= n; index++){
            long val = fibsCached.get(index-1) + fibsCached.get(index-2);
            fibsCached.add(val);
            fibsCompCount++;
        }
        return fibsCached.get(n);
    }
}

