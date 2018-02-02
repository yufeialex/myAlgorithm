package chapter_8_arrayandmatrix;

public class Problem_03_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int lH = 0;
        int lV = 0;
        int rH = 0;
        int rV = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (lH != endR + 1) {
            printLevel(matrix, lH, lV, rH, rV, fromUp);
            lH = lV == endC ? lH + 1 : lH;
            lV = lV == endC ? lV : lV + 1;
            rV = rH == endR ? rV + 1 : rV;
            rH = rH == endR ? rH : rH + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int lH, int lV, int rH, int rV,
                                  boolean f) {
        if (f) {
            while (lH != rH + 1) {
                System.out.print(m[lH++][lV--] + " ");
            }
        } else {
            while (rH != lH - 1) {
                System.out.print(m[rH--][rV++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }

}
