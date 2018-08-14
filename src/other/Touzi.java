package other;

/**
 * Created by Administrator on 2018/3/2.
 */
import java.util.*;

/**
 * 题目描述：骰子是一个立方体，每个面一个数字，初始为左1，右2，前3（观察者方向），后4，上5，下6，用123456表示这个状态，放置到平面上，可以向左翻转（用L表示向左翻转1次），可以向右翻转（用R表示向右翻转1次），可以向前翻转（用F表示向前翻转1次），可以向后翻转（用B表示向右翻转1次），可以逆时针旋转（用A表示逆时针旋转90度），可以顺时针旋转（用C表示逆时针旋转90度），现从初始状态开始，根据输入的动作序列，计算得到最终的状态。

 输入描述：

 初始状态为：123456

 输入只包含LRFBAC的字母序列，最大长度为50，可重复

 输出描述：输出最终状态

 输入例子:RA

 输出例子：436512
 */
public class Touzi {

    public static int l = 1, r = 2, f = 3, b = 4, u = 5, d = 6;

    public static void handle(char cmd) {
        int temp = 0;
        switch (cmd) {
            case 'C':
                temp = l;
                l = f;
                f = r;
                r = b;
                b = temp;
                return;
            case 'A':
                temp = r;
                r = f;
                f = l;
                l = b;
                b = temp;
                return;
            case 'F':
                temp = f;
                f = u;
                u = b;
                b = d;
                d = temp;
                return;
            case 'B':
                temp = b;
                b = u;
                u = f;
                f = d;
                d = temp;
                return;
            case 'R':
                temp = u;
                u = l;
                l = d;
                d = r;
                r = temp;
                return;
            case 'L':
                temp = u;
                u = r;
                r = d;
                d = l;
                l = temp;
                return;
            default:
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strs = scan.nextLine();
        scan.close();
        for (int i = 0; i < strs.length(); i++)
            handle(strs.charAt(i));
        System.out.println("" + l + r + f + b + u + d);
    }
}
