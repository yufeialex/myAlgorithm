package search_sort.tree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * ��ͨ������
 *
 * @author Administrator
 */
public class BinaryTree {
    private Scanner in = new Scanner(System.in);

    void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * ǰ������ķǵݹ���ʽ��
     * ˼·��
     * ������һ�ڵ�P��
     * 1������ڵ�P��Ȼ������ջ���ٿ�P�������Ƿ�Ϊ�գ�
     * 2����P�����Ӳ�Ϊ�գ�����P������Ϊ��ǰ�ڵ㣬�ظ�1���Ĳ�����
     * 3����P������Ϊ�գ���ջ���ڵ��ջ�����������������ջ�ڵ���Һ�����Ϊ��ǰ�ڵ㣬�����Ƿ�Ϊ�գ�
     * 4������Ϊ�գ���ѭ����1��������
     * 5�����Ϊ�գ��������ջ�����������ͬʱ����ջ�ڵ���Һ�����Ϊ��ǰ�ڵ㣬�����Ƿ�Ϊ�գ��ظ�4����5��������
     * 6��ֱ����ǰ�ڵ�PΪNULL����ջ�գ�����������
     *
     * @param root
     */
    void preOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node n = root;
        while (n != null || !stack.isEmpty()) {
            while (n != null) {
                System.out.print(n.data + " ");
                stack.push(n);
                n = n.left;
            }
            if (!stack.isEmpty()) {
                n = stack.peek();
                stack.pop();
                n = n.right;
            }
        }
    }

    /**
     * �������������˳�򣬶�����һ��㣬���ȷ��������ӣ������ӽ���ֿ��Կ���һ����㣬Ȼ��������������ӽ�㣬ֱ���������ӽ��Ϊ�յĽ��Ž��з��ʣ�Ȼ����ͬ�Ĺ��������������������䴦��������£�
     * <p>
     * ������һ���P��
     * <p>
     * 1)�������Ӳ�Ϊ�գ���P��ջ����P��������Ϊ��ǰ��P��Ȼ��Ե�ǰ���P�ٽ�����ͬ�Ĵ���
     * <p>
     * 2)��������Ϊ�գ���ȡջ��Ԫ�ز����г�ջ���������ʸ�ջ����㣬Ȼ�󽫵�ǰ��P��Ϊջ�������Һ��ӣ�
     * <p>
     * 3)ֱ��PΪNULL����ջΪ�����������
     *
     * @param root
     */
    void inOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node n = root;
        while (n != null || !stack.isEmpty()) {
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
            if (!stack.isEmpty()) {
                n = stack.peek();
                System.out.print(n.data + " ");
                stack.pop();
                n = n.right;
            }
        }
    }

    /**
     * Ҫ��֤����������Ӻ��Һ��ӷ���֮����ܷ��ʣ���˶�����һ���P���Ƚ�����ջ��
     * ���P���������Ӻ��Һ��ӣ������ֱ�ӷ�����������P�������ӻ����Һ��ӣ�
     * ���������Ӻ��Һ��Ӷ��ѱ����ʹ��ˣ���ͬ������ֱ�ӷ��ʸý�㡣�����������������
     * ��P���Һ��Ӻ�����������ջ��
     * �����ͱ�֤��ÿ��ȡջ��Ԫ�ص�ʱ���������Һ���ǰ�汻���ʣ����Ӻ��Һ��Ӷ��ڸ����ǰ�汻���ʡ�
     *
     * @param root
     */
    void postOrder3(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur;//��ǰ�ڵ�
        Node prev = null;//ǰһ�η��ʵĽڵ�
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null)
                    || (prev != null && (prev == cur.left ||
                    prev == cur.right
            )
            )
                    ) {
                System.out.print(cur.data + " ");
                stack.pop();
                prev = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    void BFS(Node root) {
        if (root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        print(root);
        while (!list.isEmpty()) {
            Node n = list.remove();
            if (n.left != null) {
                print(n.left);
                list.add(n.left);
            }
            if (n.right != null) {
                print(n.right);
                list.add(n.right);
            }
        }
    }

    void DFSWithStack(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            System.out.print(r.data + " ");
            if (r.right != null) {
                stack.push(r.right);
            }
            if (r.left != null) {
                stack.push(r.left);
            }
        }
    }

    void DFS(Node root) {
        if (root == null)
            return;
        print(root);
        if (root.left != null) {
            DFS(root.left);
        }
        if (root.right != null) {
            DFS(root.right);
        }
    }

    private void print(Node root) {
        System.out.print(root.data + " ");
    }

    Node build(Node root) {
        if (root == null)
            root = new Node();
        if ((root.data = in.nextInt()) == -1)
            return null;
        root.left = build(root.left);
        root.right = build(root.right);
        return root;
    }


}

class Node {
    Node left;
    Node right;
    int data;

    public Node() {
    }

    public Node(int d) {
        left = null;
        right = null;
        data = d;
    }
}