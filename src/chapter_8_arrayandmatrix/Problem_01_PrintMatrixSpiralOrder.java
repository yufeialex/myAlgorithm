package chapter_8_arrayandmatrix;

public class Problem_01_PrintMatrixSpiralOrder {

    // t是top，d是down
    public static void spiralOrderPrint(int[][] matrix) {
        int lH = 0;
        int lV = 0;
        int rH = matrix.length - 1;
        int rV = matrix[0].length - 1;
        while (lH <= rH && lV <= rV) {
            printEdge(matrix, lH++, lV++, rH--, rV--);
        }
    }

    public static void printEdge(int[][] m, int lH, int lV, int rH, int rV) {
        if (lH == rH) { // 子矩阵只有一行时
            for (int i = lV; i <= rV; i++) {
                System.out.print(m[lH][i] + " ");
            }
        } else if (lV == rV) { // 子矩阵只有一列时
            for (int i = lH; i <= rH; i++) {
                System.out.print(m[i][lV] + " ");
            }
        } else { // 一般情况
            int curV = lV;
            int curH = lH;
            while (curV != rV) {
                System.out.print(m[lH][curV] + " ");
                curV++;
            }
            while (curH != rH) {
                System.out.print(m[curH][rV] + " ");
                curH++;
            }
            while (curV != lV) {
                System.out.print(m[rH][curV] + " ");
                curV--;
            }
            while (curH != lH) {
                System.out.print(m[curH][lV] + " ");
                curH--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrderPrint(matrix);

    }

}
