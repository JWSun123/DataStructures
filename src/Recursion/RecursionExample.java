package Recursion;

public class RecursionExample {

    public static void main(String[] args) {
        printFun(5);

        //test Fibonacchi Number
        System.out.println("fibonacci 20: "+fibonacci(20));

        //test fact(n) = n!
        System.out.println("fact 5: " + fact(5));

        //test power(base, n)
        System.out.println("power, base3, n2: "+power(4, 2));

        //test find the maximum value in the input array a[] of size n.
        int a[] = {1, 4, 45, 6, -50, 10, 2};
        System.out.println(maxValue(a, a.length));
    }
    static void printFun(int test){
        if (test < 1){
            return;
        }
        System.out.printf("%d ", test);
        printFun(test - 1);
        System.out.printf("%d ", test);
        System.out.println();

    }

    // 0, 1, 1, 2, 3, 5, 8, 13
    //f(n) = f(n-1) + f(n-2)
     public static int fibonacci(int number){
        if (number == 0){
            return 0;
        }
        if (number == 1){
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
     }

     public static int fact(int n){
         if (n == 0 || n == 1) return 1;
        return fact(n-1) * n;
     }

     public static int power(int base, int n){
        if (n == 0) return 1;
        return power(base, n - 1) * base;
     }

     public static int maxValue(int[] a, int n){
        if (n == 1) return a[0];
        return Math.max(a[n-1], maxValue(a, n-1));
     }
}
