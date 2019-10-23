package search_sort.sort;

public class InsertSort {
    public static void main(String[] args) {
        int array[] = {2, 2, 8, 9, 3, 1, 5, 4, 123, 55, 33, 123};
        new InsertSort().inertionSort1(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * 最优
     * 从小到大排
     * 从前向后逐次有序
     * @param array
     */
    void sort(int array[]) {
        // 可以把i理解为轮数
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                Utils.swap(array, j, j - 1);
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

    /**
     * 这个改进下面，下面是我最初写的版本；思考如何一下子写到这个程度
     */
    void inertionSort(int array[]) // O(n*n)
    {
        int len = array.length;
        int j = 0;
        for (int i = 0; i < len - 1; i++) { // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
            // 每一轮迭代，已经有序的数组就比上次多一个元素
            int temp = array[i + 1]; //temp标记为未排序第一个元素
            for (j = i; (j >= 0) && (array[j] > temp); j--) // 每轮迭代需要用未排序数组的第一元素和已排序数组的所有元素比较，而且是从尾到头比较
            {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    // 各种排序从左到右进行和从右到左进行是一致的；只需要写出一种就行
    void sort1(int array[]) {
        int current = 0;
        int currentIndex = -1;
        for (int i = 0; i < array.length - 1; i++) { // 只需要迭代数组长度-1轮；这层循环只负责迭代次数；从头到尾或者从尾到头都是这样写
            // 每一轮迭代，已经有序的数组就比上次多一个元素
            current = array[i + 1];
            currentIndex = i + 1;
            for (int j = i; j >= 0; j--) { // 每轮迭代需要用未排序数组的第一元素和已排序数组的所有元素比较，而且是从尾到头比较
                if (current >= array[j]) {
                    break; // 这种情况都可以放在for循环的判断中
                } else {
                    array[currentIndex] = array[j];
                    currentIndex = j;
                }
            }
            if (currentIndex != -1) {
                array[currentIndex] = current;
                currentIndex = -1;
            }
        }
    }
}
