package search_sort.search;

/**
 * ���ֲ��ҷ� �ݹ���ʽ
 *
 * @author Administrator
 */
public class BinarySearchWithRecursion {
    int search(int array[], int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < key) {
                return search(array, mid + 1, high, key);
            } else if (array[mid] > key) {
                return search(array, low, high - 1, key);
            } else {
                return mid;
            }
        }
        return low;
    }

}
