package chapter_8_arrayandmatrix;

public class Problem_03_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        // 这里l是右上角的点，r是左下角的点
        int lH = 0;
        int lV = 0;
        int rH = 0;
        int rV = 0;
        int endH = matrix.length - 1;
        int endV = matrix[0].length - 1;
        boolean fromUp = false;
        while (lH != endH + 1) {
            printLevel(matrix, lH, lV, rH, rV, fromUp);
            // 所有用if else 判断的地方都可以用三目运算符，但是要考虑可读性
            lH = lV == endV ? lH + 1 : lH;
            lV = lV == endV ? lV : lV + 1;
            rV = rH == endH ? rV + 1 : rV;
            rH = rH == endH ? rH : rH + 1;
            fromUp = !fromUp; // 取反不要忘
        }
        System.out.println();
    }

    // 这里的参数可以修改，因为是值传递，不会影响原来函数中的值。
    public static void printLevel(int[][] m, int lH, int lV, int rH, int rV, boolean f) {
        if (f) {
            while (lH != rH + 1) {
                System.out.print(m[lH++][lV--] + " ");
            }
        } else {
            while (rH != lH - 1) { // 这个判断只需要横坐标一个条件就行；rH == lH 的时候是最后一个点，要打印。
                System.out.print(m[rH--][rV++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }

}
