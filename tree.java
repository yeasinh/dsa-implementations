public class BinarySearchTree {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children
            // Get the inorder successor (smallest in the right subtree)
            // Replace the to be deleted node with the successor
            root.data = minValue(root.right);
            // Delete the successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.data) {
            return true;
        }

        if (value < root.data) {
            return searchRec(root.left, value);
        }

        return searchRec(root.right, value);
    }

    // Inorder traversal of the BST (prints elements in sorted order)
    public void inorderTraversal() {
        inorderTraversalRec(root);
        System.out.println();
    }

    private void inorderTraversalRec(Node root) {
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inorderTraversalRec(root.right);
        }
    }

    // Preorder traversal of the BST
    public void preorderTraversal() {
        preorderTraversalRec(root);
        System.out.println();
    }

    private void preorderTraversalRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversalRec(root.left);
            preorderTraversalRec(root.right);
        }
    }

    // Postorder traversal of the BST
    public void postorderTraversal() {
        postorderTraversalRec(root);
        System.out.println();
    }

    private void postorderTraversalRec(Node root) {
        if (root != null) {
            postorderTraversalRec(root.left);
            postorderTraversalRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder Traversal: ");
        bst.inorderTraversal();

        System.out.print("Preorder Traversal: ");
        bst.preorderTraversal();

        System.out.print("Postorder Traversal: ");
        bst.postorderTraversal();

        System.out.println("Search for 40: " + bst.search(40));
        System.out.println("Search for 90: " + bst.search(90));

        bst.delete(30);
        System.out.print("Inorder Traversal after deleting 30: ");
        bst.inorderTraversal();
    }
}
