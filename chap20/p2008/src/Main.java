public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        System.out.println("Inorder:");
        tree.inorder();
        System.out.println("\nPostorder:");
        tree.postorder();
        System.out.println("\nPreorder:");
        tree.preorder();
        System.out.println("\nSize is"+tree.getSize());
    }
}
