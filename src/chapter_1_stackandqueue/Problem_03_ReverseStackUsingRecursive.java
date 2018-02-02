package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_03_ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 递归整体思路：画图，每层函数栈用一个长方形条表示，条中是3部分，调用点前-->调用点-->调用点后
     *
     * 递归返回实际有两种：
     * 一种是会进到无效那一层，进去先判断，不符合就返回上一层。
     * 另一种是在最后一层现做一些操作，然后再判断，不符合就返回上一层。
     * 后一种适合于想要对最后一层做特殊处理的情况，比如下面的函数。
     *
     * 下面函数还有个独特的地方，一般递归是把本函数栈的值返回给上层函数栈，上层函数帧用这个值。
     * 这里的递归，有上下层函数栈的数据传递，也有利用本层函数栈中数据。
     * 具体是，为了把栈底数据返回，通过一层层函数栈把栈底数据网上传。
     * 其他数据需要原样放入函数栈，那就用本层函数栈暂存当前层对应的栈数据（因为函数栈往下走的时候要逐层清空数据栈），
     * 等下层栈返回需要的数据后，再把本层暂存的数据塞回去。
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void gg(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = stack.pop();
        gg(stack);
        stack.push(result);
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }

}
