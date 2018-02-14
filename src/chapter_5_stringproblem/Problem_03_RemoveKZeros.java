package chapter_5_stringproblem;

public class Problem_03_RemoveKZeros {

    public static String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        char[] chas = str.toCharArray();
        int count = 0, start = -1; // start本身记录起点，但是-1这个值又让他有了flag的作用
        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                if(start == -1) { //这里也可以用前面是否是0作为判断，但是就要分情况了，不如这个简洁
                    start = i;
                }
            } else {
                if (count == k) {
                    while (count-- != 0)
                        chas[start++] = 0; // 这里注意，char等于0和等于' '是一样的效果！
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0)
                chas[start++] = 0;
        }
        return String.valueOf(chas); // 最后返回字符串
    }

    public static void main(String[] args) {
        String test1 = "0A0B0C00D0";
        System.out.println(removeKZeros(test1, 1));

        String test2 = "00A00B0C00D0";
        System.out.println(removeKZeros(test2, 2));

        String test3 = "0000A00B000C0D00";
        System.out.println(removeKZeros(test3, 3));

        String test4 = "0000A0000B00C000D0000";
        System.out.println(removeKZeros(test4, 4));

        String test5 = "00000000";
        System.out.println(removeKZeros(test5, 5));

    }

}
