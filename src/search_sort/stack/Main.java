package search_sort.stack;

public class Main {
    public static void main(String[] args) {
        StackInList sil = new StackInList();
        sil.push(1);
        sil.push(2);
        sil.push(3);
        System.out.println(sil.pop());
        System.out.println(sil.pop());
        System.out.println(sil.pop());
        System.out.println(sil.pop());
    }

}
