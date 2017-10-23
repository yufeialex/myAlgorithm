package search_sort.sort;

/**
 * �����зֵĿ�������
 *
 * @author Administrator
 */
public class Quick3way {
    public static void main(String[] args) {
        int array[] = {2, 2, 8, 9, 3, 1, 5, 4, 123, 55, 33, 123};
        new MergeSort().sort(array, 0, 7);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[], int low, int high) {
        if (high <= low) return;
        int lt = low, i = low + 1, gt = high;
        int v = array[low];
        while (i <= gt) {
            if (array[i] < v) {
                Utils.exec(array, lt++, i++);
            } else if (array[i] > v) {
                Utils.exec(array, i, gt--);
            } else {
                i++;
            }
        }
        sort(array, low, lt - 1);
        sort(array, gt + 1, high);

    }

}
