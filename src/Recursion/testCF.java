package Recursion;


public class testCF {
    public static void main(String[] args) {
        FiboCache fiboCache = new FiboCache();
        System.out.println(fiboCache.getNthFib(8));
        System.out.println(fiboCache.toString());
    }
}
