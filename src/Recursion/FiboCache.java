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
        if (n <= fibsCompCount) {
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
        String s = "FiboCache：";
        for (int i = 0; i < fibsCached.size(); i++) {
            s += i == 0 ? "" : ", ";
            s += fibsCached.get(i);
        }
        return s;
    }

}

