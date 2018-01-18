package search_sort.tree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 锟斤拷通锟斤拷锟斤拷锟斤拷
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
     * 前锟斤拷锟斤拷锟斤拷姆堑莨锟斤拷锟绞斤拷锟?
     * 思路锟斤拷
     * 锟斤拷锟斤拷锟斤拷一锟节碉拷P锟斤拷
     * 1锟斤拷锟斤拷锟斤拷诘锟絇锟斤拷然锟斤拷锟斤拷锟斤拷栈锟斤拷锟劫匡拷P锟斤拷锟斤拷锟斤拷锟角凤拷为锟秸ｏ拷
     * 2锟斤拷锟斤拷P锟斤拷锟斤拷锟接诧拷为锟秸ｏ拷锟斤拷锟斤拷P锟斤拷锟斤拷锟斤拷为锟斤拷前锟节点，锟截革拷1锟斤拷锟侥诧拷锟斤拷锟斤拷
     * 3锟斤拷锟斤拷P锟斤拷锟斤拷锟斤拷为锟秸ｏ拷锟斤拷栈锟斤拷锟节碉拷锟秸伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷栈锟节碉拷锟斤拷液锟斤拷锟斤拷锟轿拷锟角帮拷诘悖拷锟斤拷锟斤拷欠锟轿拷眨锟?
     * 4锟斤拷锟斤拷锟斤拷为锟秸ｏ拷锟斤拷循锟斤拷锟斤拷1锟斤拷锟斤拷锟斤拷锟斤拷
     * 5锟斤拷锟斤拷锟轿拷眨锟斤拷锟斤拷锟斤拷锟斤拷栈锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵憋拷锟斤拷锟秸伙拷诘锟斤拷锟揭猴拷锟斤拷锟斤拷为锟斤拷前锟节点，锟斤拷锟斤拷锟角凤拷为锟秸ｏ拷锟截革拷4锟斤拷锟斤拷5锟斤拷锟斤拷锟斤拷锟斤拷
     * 6锟斤拷直锟斤拷锟斤拷前锟节碉拷P为NULL锟斤拷锟斤拷栈锟秸ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
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
     * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟剿筹拷颍锟斤拷锟斤拷锟揭伙拷锟姐，锟斤拷锟饺凤拷锟斤拷锟斤拷锟斤拷锟接ｏ拷锟斤拷锟斤拷锟接斤拷锟斤拷挚锟斤拷钥锟斤拷锟揭伙拷锟斤拷锟姐，然锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷咏锟姐，直锟斤拷锟斤拷锟斤拷锟斤拷锟接斤拷锟轿拷盏慕锟斤拷沤锟斤拷蟹锟斤拷剩锟饺伙拷锟斤拷锟酵拷墓锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷浯︼拷锟斤拷锟斤拷锟斤拷锟铰ｏ拷
     * <p>
     * 锟斤拷锟斤拷锟斤拷一锟斤拷锟絇锟斤拷
     * <p>
     * 1)锟斤拷锟斤拷锟斤拷锟接诧拷为锟秸ｏ拷锟斤拷P锟斤拷栈锟斤拷锟斤拷P锟斤拷锟斤拷锟斤拷锟斤拷为锟斤拷前锟斤拷P锟斤拷然锟斤拷缘锟角帮拷锟斤拷P锟劫斤拷锟斤拷锟斤拷同锟侥达拷锟斤拷
     * <p>
     * 2)锟斤拷锟斤拷锟斤拷锟斤拷为锟秸ｏ拷锟斤拷取栈锟斤拷元锟截诧拷锟斤拷锟叫筹拷栈锟斤拷锟斤拷锟斤拷锟斤拷锟绞革拷栈锟斤拷锟斤拷悖伙拷蠼锟角帮拷锟絇锟斤拷为栈锟斤拷锟斤拷锟斤拷锟揭猴拷锟接ｏ拷
     * <p>
     * 3)直锟斤拷P为NULL锟斤拷锟斤拷栈为锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟?
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
     * 要锟斤拷证锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷雍锟斤拷液锟斤拷臃锟斤拷锟街拷锟斤拷锟杰凤拷锟绞ｏ拷锟斤拷硕锟斤拷锟斤拷锟揭伙拷锟斤拷P锟斤拷锟饺斤拷锟斤拷锟斤拷栈锟斤拷
     * 锟斤拷锟絇锟斤拷锟斤拷锟斤拷锟斤拷锟接猴拷锟揭猴拷锟接ｏ拷锟斤拷锟斤拷锟街憋拷臃锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絇锟斤拷锟斤拷锟斤拷锟接伙拷锟斤拷锟揭猴拷锟接ｏ拷
     * 锟斤拷锟斤拷锟斤拷锟斤拷锟接猴拷锟揭猴拷锟接讹拷锟窖憋拷锟斤拷锟绞癸拷锟剿ｏ拷锟斤拷同锟斤拷锟斤拷锟斤拷直锟接凤拷锟绞该斤拷恪ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
     * 锟斤拷P锟斤拷锟揭猴拷锟接猴拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷栈锟斤拷
     * 锟斤拷锟斤拷锟酵憋拷证锟斤拷每锟斤拷取栈锟斤拷元锟截碉拷时锟斤拷锟斤拷锟斤拷锟斤拷锟揭猴拷锟斤拷前锟芥被锟斤拷锟绞ｏ拷锟斤拷锟接猴拷锟揭猴拷锟接讹拷锟节革拷锟斤拷锟角帮拷姹伙拷锟斤拷省锟?
     *
     * @param root
     */
    void postOrder3(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur;//锟斤拷前锟节碉拷
        Node prev = null;//前一锟轿凤拷锟绞的节碉拷
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