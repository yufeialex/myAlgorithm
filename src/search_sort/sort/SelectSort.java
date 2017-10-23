package search_sort.sort;

/**
 * ѡ������
 *
 * @author Administrator
 */
public class SelectSort {
    public static void main(String[] args) {
        int array[] = {2, 2, 8, 9, 2, 2, 8, 9, 3, 1, 5, 4, 123, 55, 33, 123};
        new SelectSort().sort1(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            Utils.exec(array, i, min);
        }
    }

    void sort1(int array[]) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) { // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
            // 每一轮迭代，已经有序的数组就比上次多一个元素
            int index = i;
            for (int j = i + 1; j < len; j++) // 每轮迭代需要在未排序数组选出最小的，然后放到已排序数组的最后一个位置
            {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            Utils.exec(array, i, index);
        }
    }
}
