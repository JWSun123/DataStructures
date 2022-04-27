package Cross;

import java.util.Arrays;

public class Cross {
    public static void main(String[] args) {
        int[][] data2D = {
                {1, 3, 6, 8},
                {7, 1, 2, 3},
                {8, 3, 2, 1},
                {1, 7, 1, 9}
        };
        System.out.println(getIfExists(data2D, 2, 3)); // 1
        System.out.println(getIfExists(data2D, 5, 3)); // 0
        System.out.println(sumOfCross(data2D, 2, 3)); // 15
        System.out.println(sumOfCross(data2D, 1, 2)); // 14
        System.out.println(sumOfCross(data2D, 2, 2)); // 9
        System.out.println(sumOfCross(data2D, 0, 0)); // 11


        print2D(data2D);
        System.out.println();
        print2D(duplicateEmptyArray2D(data2D));
        System.out.println();
        System.out.println(Arrays.toString(findSmallestSum(data2D))); // [2, 2] [row, col]
        System.out.println();
        print2D(sumCross2d(data2D));
    }

    static int getIfExists(int[][] data, int row, int col) {
        if (row >= data.length || row < 0 || col >= data[0].length || col < 0) {
            return 0;
        } else {
            return data[row][col];
        }
    }

    static int sumOfCross(int[][] data, int row, int col) {

        int above = getIfExists(data, row - 1, col);
        int below = getIfExists(data, row + 1, col);
        int left = getIfExists(data, row, col - 1);
        int right = getIfExists(data, row, col + 1);

        return above + below + left + right + getIfExists(data, row, col);
    }

    static void print2D(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (j == 0) {
                    System.out.printf("{" + data[i][j] + ", ");
                } else if (j == data[0].length - 1) {
                    System.out.printf(data[i][j] + "},");
                    System.out.println();
                } else {
                    System.out.printf(data[i][j] + ", ");
                }
            }
        }
    }

    static int[][] duplicateEmptyArray2D(int[][] org2d) {
        int[][] new2d = new int[org2d.length][org2d[0].length];
//        for (int i = 0; i < org2d.length; i++){
//            for (int j = 0; j < org2d[0].length; j++){
//                new2d[i][j] = org2d[i][j];
//            }
//        }
        return new2d;
    }

    static int[] findSmallestSum(int[][] data) {
        int[] result = new int[2];
        int smallestSum = sumOfCross(data, 0, 0);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                int sumOfCross = sumOfCross(data, i, j);
                if (sumOfCross < smallestSum) {
                    smallestSum = sumOfCross;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    static int[][] sumCross2d(int[][] data) {
        int[][] result = duplicateEmptyArray2D(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i][j] = sumOfCross(data, i, j);
            }
        }
        return result;
    }
}
