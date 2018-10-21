package arboles;



public class ArbolAVL {

    AVLNode root = null;

    public int height(AVLNode node) {
        if (node == null)
            return 0;

        return node.getHeight();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();
        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // Update heights
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    public int getBalance(AVLNode node) {
        if (node == null)
            return 0;

        return height(node.getLeft()) - height(node.getRight());
    }

    public AVLNode insert(AVLNode node, int key) {

        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode(key));

        if (key < node.getKey())
            node.setLeft(insert(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insert(node.getRight(), key));
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

		/* 3. Get the balance factor of this ancestor
			node to check whether this node became
			unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key <  node.getLeft().getKey())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key >  node.getRight().getKey())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.getLeft().getKey()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.getRight().getKey()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static void main(String[] args) {
        ArbolAVL tree = new ArbolAVL();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 4);


		/* The constructed AVL Tree would be
			30
			/ \
		   20 40
		  / \	\
		 10 25  50
		*/
        System.out.println("Preorder traversal" + " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
    
    public class AVLNode {
        private int key = 0;
        private int height = 0;
        private AVLNode left = null;
        private AVLNode right = null;

        public AVLNode(int d) {
            key = d;
            height = 1;
        }

        public int getKey() {
            return key;
        }

        public void setHeight(int height){
            this.height = height;
        }

        public int getHeight(){
            return height;
        }

        public void setLeft(AVLNode left){
            this.left = left;
        }

        public AVLNode getLeft(){
            return left;
        }

        public void setRight(AVLNode right){
            this.right = right;
        }

        public AVLNode getRight(){
            return right;
        }

    }
}
