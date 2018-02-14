package chapter_5_stringproblem;

public class Problem_01_IsDeformation {

    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++) {
            //先用再减减
            // 两个串长度一定是相等的，那么但凡map[chas2[i]]是0，一定是没出现过的字符；或者出现次数比str1多
            if (map[chas2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String A = "abcabcabc";
//        String B = "bcacbaacb";
        String A = "123456";
        String B = "123452";
        System.out.println(isDeformation(A, B));

    }

}
