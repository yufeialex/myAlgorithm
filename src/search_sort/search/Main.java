package search_sort.search;

public class Main {
    public static void main(String[] args) {
        BinarySearchWithRecursion bs = new BinarySearchWithRecursion();
        int array[] = {1, 3, 5, 7, 9, 11, 17};
        int key = 999;
        System.out.println(bs.search(array, 0, 6, key));
    }
}
