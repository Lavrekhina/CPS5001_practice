package week_4_Trees;

class BinaryTree {
    BinaryTreeNode root;
    public BinaryTree() {
        root = null;
    }
    // Insert a node in the Binary Tree
    public BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    // Find the minimum value node
    public BinaryTreeNode minValueNode(BinaryTreeNode node) {
        BinaryTreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    // Delete a node from the Binary Tree
    public BinaryTreeNode delete(BinaryTreeNode root, int data) {
        if (root == null) {
            return root;
        }
// Traverse the tree
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
// Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
// Node with two children: get the inorder successor (smallest in the right
            BinaryTreeNode temp = minValueNode(root.right);
// Replace the data with inorder successor's data
            root.data = temp.data;
// Delete the inorder successor
            root.right = delete(root.right, temp.data);
        }
        return root;
    }
    // In-order traversal (Left, Root, Right)
    public void inorder(BinaryTreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    // Pre-order traversal (Root, Left, Right)
    public void preorder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    // Post-order traversal (Left, Right, Root)
    public void postorder(BinaryTreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);
        System.out.println("In-order traversal:");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Pre-order traversal:");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Post-order traversal:");
        tree.postorder(tree.root);
        System.out.println();
        System.out.println("Delete 20");
        tree.delete(tree.root, 20);
        System.out.println("In-order traversal after deletion:");
        tree.inorder(tree.root);
        System.out.println();
    }
}