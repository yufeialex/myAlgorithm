package chapter_3_binarytreeproblem;

import java.util.HashMap;

public class Problem_21_PreInPosArrayToTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    /**
     *
     * @param pre 前序数组
     * @param preFirst 前序第一个节点的index
     * @param preLast 前序最后一个节点的index
     * @param in 中序数组
     * @param inFirst 中序第一个节点的index
     * @param inLast 中序最后一个节点的index
     * @param map 中序的哈希数组
     * @return
     */
    public static Node preIn(int[] pre, int preFirst, int preLast, int[] in, int inFirst, int inLast, HashMap<Integer, Integer> map) {
        if (preFirst > preLast) {
            return null;
        }
        Node head = new Node(pre[preFirst]);
        int index = map.get(pre[preFirst]);
        head.left = preIn(pre, preFirst + 1, preFirst + index - inFirst, in, inFirst, index - 1, map);
        head.right = preIn(pre, preFirst + index - inFirst + 1, preLast, in, index + 1, inLast, map);
        return head;
    }

    public static Node inPosToTree(int[] in, int[] pos) {
        if (in == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, map);
    }

    public static Node inPos(int[] in, int inFirst, int inLast, int[] pos, int posFirst, int posLast, HashMap<Integer, Integer> map) {
        if (posFirst > posLast) {
            return null;
        }
        Node head = new Node(pos[posLast]);
        int index = map.get(pos[posLast]);
        head.left = inPos(in, inFirst, index - 1, pos, posFirst, posFirst + index - inFirst - 1, map);
        head.right = inPos(in, index + 1, inLast, pos, posFirst + index - inFirst, posLast - 1, map);
        return head;
    }

    // 每个节点的孩子数都为0或者2的二叉树才能被先序与后序重构出来
    public static Node prePosToTree(int[] pre, int[] pos) {
        if (pre == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < pos.length; i++) {
            map.put(pos[i], i);
        }
        return prePos(pre, 0, pre.length - 1, pos, 0, pos.length - 1, map);
    }

    public static Node prePos(int[] pre, int preFirst, int preLast, int[] pos, int posFirst, int posLast, HashMap<Integer, Integer> map) {
        Node head = new Node(pos[posLast--]);
        if (preFirst == preLast) {
            return head;
        }
        int index = map.get(pre[++preFirst]);
        head.left = prePos(pre, preFirst, preFirst + index - posFirst, pos, posFirst, index, map);
        head.right = prePos(pre, preFirst + index - posFirst + 1, preLast, pos, index + 1, posLast, map);
        return head;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[] in = {4, 2, 8, 5, 9, 1, 6, 3, 7};
        int[] pos = {4, 8, 9, 5, 2, 6, 7, 3, 1};
        printTree(preInToTree(pre, in));
        printTree(inPosToTree(in, pos));
        printTree(prePosToTree(pre, pos));

    }

}
