package search_sort.tree;

public class Main {

    public void testBinaryTree() throws Exception {
        BinaryTree tree = new BinaryTree();
        Node root = null;
        root = tree.build(root);
        System.out.println("inOrder2------");
        tree.inOrder2(root);
        /*System.out.println("\nDFSWithStack-----");
		tree.DFSWithStack(root);*/
		/*System.out.println("\nBFS-----");
		tree.BFS(root);*/
    }
}
