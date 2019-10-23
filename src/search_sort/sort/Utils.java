package search_sort.sort;

public class Utils {

    public static void swap(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

    public static boolean less(int i, int j) {
        return i < j;
    }


}
