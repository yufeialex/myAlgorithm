package search_sort.sort;

public class MergeSort {
    public static void main(String[] args) {
        int array[] = {1, 3, 2, 1, 1, 1, 5, 6, 8, 9, 0};
        new MergeSort().sort(array, 0, array.length - 1);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }

    }

    public void merge(int[] array, int low, int mid, int high) {
        int copyarray[] = new int[array.length];
        for (int i = 0; i <= high; i++) {
            copyarray[i] = array[i];
        }
        int left = low;
        int right = mid + 1;
        int current = low;
        while (left <= mid && right <= high) {
            if (copyarray[left] < copyarray[right]) {
                array[current++] = copyarray[left];
                left++;
            } else {
                array[current++] = copyarray[right];
                right++;
            }
        }
        int remaining = mid - left;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = copyarray[left + i];
        }
    }

}
