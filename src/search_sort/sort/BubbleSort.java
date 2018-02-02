package search_sort.sort;

/**
 * ð�ݷ�����
 *
 * @author Administrator
 */
public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {7, 3, 5, 4, 1123, 6, 8, 5};
        new BubbleSort().sort2(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * 从小到大排，把最大的元素冒泡上去
     * 从大到小排，把最小的元素冒泡上去
     *
     * 从左向右冒泡
     *
     * 如果想象成水面的话，湖底-->湖面，冒泡上去
     *
     * @param array
     */
    void sort1(int array[]) {
        boolean exchange = true;
        for (int i = 0; i < (array.length - 1) && exchange; i++) { // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
            // 每一轮迭代，都比上一轮少比较一次，减少一个参与比较的元素;这个冒泡到队尾，队尾减少
            for (int j = 0; j < array.length - 1 - i; j++) { // 每轮迭代需要参与比较的元素个数是 数组长度-迭代轮数；i代表迭代轮数；
                if (array[j] < array[j + 1]) { // 这里决定是从大到小还是从小到大
                    Utils.exec(array, j, j + 1);
                    exchange = true;
                }
            }
        }
    }

    /**
     * 从右向左冒泡
     *
     * 如果想象成水面的话，湖底<--湖面，冒泡上去
     *
     * @param array
     */
    void sort2(int array[]) {
        boolean exchange = true;
        for (int i = 0; i < (array.length - 1) && exchange; i++) { // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
            // 每一轮迭代，都比上一轮少比较一次，减少一个参与比较的元素;这个冒泡到队首，队首减少
            exchange = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    Utils.exec(array, j, j - 1);
                    exchange = true;
                }
            }
        }
    }
}
