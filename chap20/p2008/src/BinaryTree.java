public class BinaryTree {
    private TreeNode root;
    private int size = 0;

    public BinaryTree() {
    }

    public BinaryTree(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    //将节点插入进树中。
    public boolean insert(Object object) {
        if (root == null)  root = new TreeNode(object);//将object类型包装一下。
        else{
            //定位父亲节点
            TreeNode parent = null;
            TreeNode current = root;

            //1.查找新元素的父节点。
            while (current!=null){
                if(((Comparable)object).compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                }else if(((Comparable)object).compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }else{
                    return false;//重复节点不添加。
                }
            }

            //2.找到父亲节点后，进行插入操作。这块相当于是拿引用，直接给引用赋值，这样root底下的所有节点也会和parent一样
            // 得到更新。
            if(((Comparable)object).compareTo(parent.element)<0){
                parent.left = new TreeNode(object);
            }else{
                parent.right = new TreeNode(object);
            }
        }
        size++;
        return true;
    }

    //中序遍历
    public void inorder(){
        inorder(root);
    }

    //左根右，递归法
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.element+" ");
        inorder(root.right);
    }

    public void postorder(){
        postorder(root);
    }

    public void postorder(TreeNode root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element+" ");
    }

    public void preorder(){
        preorder(root);
    }

    public void preorder(TreeNode root){
        if(root == null) return;
        System.out.println(root.element+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public int getSize() {
        return size;
    }
}
