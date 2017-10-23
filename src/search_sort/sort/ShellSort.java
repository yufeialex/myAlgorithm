package search_sort.sort;

public class ShellSort {
    public static void main(String[] args) {
        int array[] = {2, 2, 8, 9, 3, 1, 5, 4, 123, 55, 33, 123};
        new ShellSort().sort1(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[]) {
        int N = array.length;
        int gap = 1;
        while (gap < N / 3) gap = 3 * gap + 1;
        while (gap >= 1) {
            for (int i = gap; i < N; i++) {
                for (int j = i; j >= gap && Utils.less(array[j], array[j - gap]); j -= gap) {
                    Utils.exec(array, j, j - gap);
                }
            }
            gap = gap / 3;
        }
    }

    void sort1(int array[]) {
        int len = array.length;
        int gap = 1;
        while (gap < len / 3) { // 从1开始增加，但是不要超过长度的三分之一
            gap = 3 * gap + 1;
        }
        while (gap >= 1) {
            int j = 0;
            // 两层for循环中，几个分组是交替进行的
            for (int i = gap; i < len; i++) { // 每个小数组都只需要迭代数组长度-1轮；但是写法有2中，从0到长度-1，从1到长度；总的数组需要迭代总长度-gap
                int temp = array[i]; // temp标记为未排序第一个元素
                for (j = i; (j >= gap) && (array[j - gap] > temp); j -= gap) // 这里注意是>=
                {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            gap = gap / 3;
        }

    }

    void ssort(int array[]) {
        int len = array.length;
        int i = 0;
        int j = 0;
        int temp = 0;
        int gap = len;
        while (gap > 0) {
            gap = gap / 3 + 1;
            for (i = gap; i < len; i++) {
                temp = array[i];
                for (j = i - gap; (j >= 0) && (array[j] > temp); j -= gap)//注意这里是>=0
                {
                    array[j + gap] = array[j];
                }
                array[i + gap] = temp;
            }
        }

    }


}
