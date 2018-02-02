package chapter_8_arrayandmatrix;

public class Problem_02_RotateMatrix {

    public static void rotate(int[][] matrix) {
        int lH = 0;
        int lV = 0;
        int rH = matrix.length - 1;
        int rV = matrix[0].length - 1;
        while (lH < rH) {
            rotateEdge(matrix, lH++, lV++, rH--, rV--);
        }
    }

    public static void rotateEdge(int[][] m, int lH, int lV, int rH, int rV) {
        int times = rV - lV; // times就是总的组数
        int tmp = 0;
        for (int i = 0; i != times; i++) { // 一次循环就是一组位置调整
            tmp = m[lH][lV + i];
            m[lH][lV + i] = m[rH - i][lV];
            m[rH - i][lV] = m[rH][rV - i];
            m[rH][rV - i] = m[lH + i][rV];
            m[lH + i][rV] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}
