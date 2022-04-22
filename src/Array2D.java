import java.util.*;
import java.util.stream.Collectors;

public class Array2D {
    public static void main(String[] args) {
        // two ways to define a 2d array.
        int[][] array2d1 = new int[3][];
        int[][] array2d2 = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}, {10}}; //jagged array.
        // to get 4.
        System.out.println(array2d2[1][1]);

        //to print out everything. nested loop.
        for (int i = 0; i < array2d2.length; i++) {
            for (int j = 0; j < array2d2[i].length; j++) {
                System.out.printf("%d ", array2d2[i][j]);
            }
            System.out.println();
        }
//Exercise 2
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the width of the array:");
            int width = input.nextInt();
            System.out.println("Enter the height of the array:");
            int height = input.nextInt();
            if (width >= 1 && height >= 1) {
                //allocate 2d array of integers of given width and height.
                int[][] array = new int[width][height];
                // generate random value for the array. -99 to 99.
                System.out.println("Display array: ");
                for (int[] arr : array) {
                    for (int i = 0; i < arr.length; i++) {
                        //int number = random.nextInt(max - min) + min;
                        //OR -99 + (int) (Math.random() * 99)
                        arr[i] = -100 + new Random().nextInt(200);

                        System.out.printf("%s%4d", i == 0 ? "" : ", ", arr[i]);
                    }
                    System.out.println();
                }
                //Sum of all numbers in the array.
                System.out.println("Sum of all numbers: ");
                System.out.println(sumAll(array));

                //Sum of each of the row of the array
                System.out.println("Sum of each rows: ");
                int[] rowSum = sumRow(array);
                for (int i = 0; i < rowSum.length; i++) {
                    System.out.printf("%s%d", i == 0 ? "" : ", ", rowSum[i]);
                }
                System.out.println();

                //Sum of each of the column of the array
                System.out.println("Sum of each columns: ");
                int[] columnSum = sumColumn(array);
                for (int i = 0; i < columnSum.length; i++) {
                    System.out.printf("%s%d", i == 0 ? "" : ", ", columnSum[i]);
                }
                System.out.println();

                //Standard deviation of all numbers in the array.
                System.out.printf("Standard Deviation of all numbers: %.3f\n", standardDeviation(array));

                //Find pairs of numbers in the array whose sum is a prime number and display those pairs and their sum.(assume that negative number is not a prime number)
                System.out.println("pairs whose sum is a prime number (first two elements are the pair, the last element is the sum): ");
                ArrayList<int[]> pairs= findPrimePairs(array);
                for (int[] pair: pairs) {
                    System.out.println(Arrays.toString(pair));
                }

            } else {
                throw new IllegalArgumentException("Must be greater than 1.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Input Invalid! Must be an integer.");
        }
    }

    public static int sumAll(int[][] array) {
        int result = 0;
        for (int[] arr : array) {
            for (int i = 0; i < arr.length; i++) {
                result += arr[i];
            }
        }
        return result;
    }

    public static int[] sumRow(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                rowSum += array[i][j];
            }
            System.out.printf("the sum of row %d is: %d \n", i+1, rowSum);
            result[i] = rowSum;
        }
        return result;
    }

    public static int[] sumColumn(int[][] array) {
        int length = array[0].length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int columnSum = 0;
            for (int j = 0; j < array.length; j++) {
                columnSum += array[j][i];
            }
            result[i] = columnSum;
            System.out.printf("the sum of column %d is: %d \n", i+1, columnSum);
        }
        return result;
    }

    public static double standardDeviation(int[][] array) {
        double standardDeviation = 0.0;
        int n = array.length * array[0].length;
        double mean = sumAll(array) / n;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                standardDeviation += Math.pow(array[i][j] - mean, 2);
            }
        }
        return Math.sqrt(standardDeviation / n);
    }

    public static ArrayList findPrimePairs(int[][] array) {
        ArrayList<int[]> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        System.out.println("List of all numbers: " + list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (isPrime(sum)){
                    result.add(new int[]{list.get(i), list.get(j), sum});
                }
            }
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        //Math.sqrt() returns the square root of a value.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}