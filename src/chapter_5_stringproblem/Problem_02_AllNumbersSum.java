package chapter_5_stringproblem;

// 7个注释，7个需要注意的地方
public class Problem_02_AllNumbersSum {

    // 不考虑溢出情况
    public static int numSum(String str) {
        if (str == null) { // 最基础的的检验
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') { // char的比较
                    if (i - 1 > -1 && charArr[i - 1] == '-') { // 最开始就是-的情况
                        posi = !posi; // 取反的方法
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur); // 负数的搞法
            }
        }
        res += num; // 最后也可能是数字
        return res;
    }

    public static void main(String[] args) {
        String test = "1K-100ABC500D-T--100F200G!!100H---300";
        System.out.println(numSum(test));

    }

}
