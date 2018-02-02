package search_sort.sort;

/**
 * ��������
 *
 * @author Administrator
 */
public class QuickSort {
    public static void main(String[] args) {
        int array[] = {7, 6, 5, 4, 4, 3, 2, 1};
        new QuickSort().sort(array, 0, array.length - 1);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[], int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            sort(array, left, index - 1);
            sort(array, index + 1, right);
        }

    }

    public static int partition(int[] array, int left, int right) {
        //固定的切分方式
        int key = array[left];
        while (left < right) {
            while (array[right] >= key && right > left) { //从后半部分向前扫描
                right--;
            }
            array[left] = array[right];
            while (array[left] <= key && right > left) { //从前半部分向后扫描
                left++;
            }
            // 这里一定要用right，因为有一种情况是左边大于右边了；这种情况下用left就出错了。
            array[right] = array[left];
        }
        array[right] = key;
        return right;
    }

    public int partition1(int[] array, int left, int right) {
        if (array == null || array.length <= 0 || left < 0 || right >= array.length) {
            return 0;
        }
        int prio = array[left + (right - left) / 2];
        while (left <= right) {
            while (array[left] < prio)
                left++;
            while (array[right] > prio)
                right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
