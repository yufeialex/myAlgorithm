package search_sort.sort;

public class InsertSort {
    public static void main(String[] args) {
        int array[] = {2, 2, 8, 9, 3, 1, 5, 4, 123, 55, 33, 123};
        new InsertSort().inertionSort1(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && Utils.less(array[j], array[j - 1]); j--) {
                Utils.exec(array, j, j - 1);
            }
        }
    }

    void inertionSort1(int array[]) // O(n*n)
    {
        int len = array.length;
        int j = 0;
        for (int i = 1; i < len; i++) { // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
            // 每一轮迭代，已经有序的数组就比上次多一个元素
            int temp = array[i]; //temp标记为未排序第一个元素
            for (j = i; (j > 0) && (array[j - 1] > temp); j--) // 每轮迭代需要用未排序数组的第一元素和已排序数组的所有元素比较，而且是从尾到头比较;只有大于才会进去，相等的时候不进去，稳定的
            {
                array[j] = array[j - 1];
            }
            array[j] = temp; // 这里其实包含了原地不动的情况
        }
    }
}
