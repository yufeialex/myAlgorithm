package chapter_5_stringproblem;

public class Problem_10_ModifyAndReplace {

    public static void replace(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0; // 左半区空格数
        int len = 0; // 左半区长度
        // 左右半区的界限是0
        for (len = 0; len < chas.length && chas[len] != 0; len++) {
            if (chas[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 - 1;
        for (int i = len - 1; i > -1; i--) {
            if (chas[i] != ' ') {
                chas[j--] = chas[i];
            } else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
    }

    public static void modify(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int j = chas.length - 1;
        for (int i = chas.length - 1; i > -1; i--) {
            // 不会出现覆盖问题，如果是*，什么都不做；如果不是，自己还在自己位置，或者覆盖*的位置；
            // j和i两个指针，i一定会移动；j不一定，只在遇到非空格的时候移动
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        // 这里用不怎么动的那个指针
        for (; j > -1; ) {
            chas[j--] = '*';
        }
    }

    public static void main(String[] args) {
        char[] chas1 = {'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0,};
//        char[] chas1 = {'a', ' ', 'b', ' ', ' ', 'c', 1, 1, 1, 1, 1, 1, 1, 1};
        replace(chas1);
        System.out.println(String.valueOf(chas1));

        char[] chas2 = {'1', '2', '*', '*', '3', '4', '5'};
        modify(chas2);
        System.out.println(String.valueOf(chas2));

    }

}
