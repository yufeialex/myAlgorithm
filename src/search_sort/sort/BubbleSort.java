package search_sort.sort;

/**
 *
 *
 * @author Administrator
 */
public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {7, 3, 5, 4, 1123, 6, 8, 5};
        new BubbleSort().sort1(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * 这个是最优的，记住这个
     *
     * 从小到大排
     * 把最大的元素沉底
     * 从左向右沉底
     */
    void sort1(int array[]) {
        boolean exchange = true;
        // 只需要迭代（数组长度-1）轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
        for (int i = 1; i < array.length && exchange; i++) {
            // 每一轮迭代，都比上一轮少比较一次，减少一个参与比较的元素;
            // 减少的个数正好是i
            // 每轮迭代需要参与比较的元素个数是 数组长度-迭代轮数；
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                    exchange = true;
                }
            }
        }
    }

    /**
     * 从小到大排，把最小的元素冒泡
     * 从右向左冒泡
     */
    void sort2(int array[]) {
        boolean exchange = true;
        // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
        for (int i = 0; i < (array.length - 1) && exchange; i++) {
            // 每一轮迭代，都比上一轮少比较一次，减少一个参与比较的元素;
            exchange = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    Utils.swap(array, j, j - 1);
                    exchange = true;
                }
            }
        }
    }

    /**
     * 从小到大排，把最大的元素沉底
     * 从左向右沉底
     *
     */
    void sort3(int array[]) {
        boolean exchange = true;
        for (int i = array.length - 1; i > 0 && exchange; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                    exchange = true;
                }
            }
        }
    }
}
