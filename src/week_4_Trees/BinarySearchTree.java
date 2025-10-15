package week_4_Trees;

class BinarySearchTreeNode {
    int data;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    public BinarySearchTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // -------------------------------
    // INSERTION
    // -------------------------------
    public BinarySearchTreeNode insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new BinarySearchTreeNode(value);
            } else {
                left = left.insert(value);
            }
        } else if (value > data) {
            if (right == null) {
                right = new BinarySearchTreeNode(value);
            } else {
                right = right.insert(value);
            }
        }
        return this; // Return unchanged node
    }

    // -------------------------------
    // SEARCH
    // -------------------------------
    public BinarySearchTreeNode search(int value) {
        if (value == data) {
            return this; // Value found
        } else if (value < data) {
            return (left != null) ? left.search(value) : null;
        } else {
            return (right != null) ? right.search(value) : null;
        }
    }

    // -------------------------------
    // DELETE
    // -------------------------------
    public BinarySearchTreeNode delete(int value) {
        if (value < data) {
            if (left != null) left = left.delete(value);
        } else if (value > data) {
            if (right != null) right = right.delete(value);
        } else {
            // Node with one or zero children
            if (left == null) return right;
            else if (right == null) return left;

            // Node with two children → replace with inorder successor
            BinarySearchTreeNode successor = right.findMin();
            data = successor.data;
            right = right.delete(successor.data);
        }
        return this;
    }

    // -------------------------------
    // FIND MINIMUM NODE (used for deletion)
    // -------------------------------
    public BinarySearchTreeNode findMin() {
        return (left != null) ? left.findMin() : this;
    }

    // -------------------------------
    // IN-ORDER TRAVERSAL (Left, Root, Right)
    // -------------------------------
    public void inOrderTraversal() {
        if (left != null) left.inOrderTraversal();
        System.out.print(data + " ");
        if (right != null) right.inOrderTraversal();
    }

    // -------------------------------
    // MAIN METHOD FOR TESTING
    // -------------------------------
    public static void main(String[] args) {
        BinarySearchTreeNode root = new BinarySearchTreeNode(10);
        root = root.insert(5);
        root = root.insert(15);
        root = root.insert(3);
        root = root.insert(7);
        root = root.insert(12);
        root = root.insert(17);

        System.out.println("In-order traversal:");
        root.inOrderTraversal(); // Should print: 3 5 7 10 12 15 17
        System.out.println();

        BinarySearchTreeNode searchResult = root.search(7);
        System.out.println("Search for 7: " + (searchResult != null ? "Found" : "Not Found"));

        root = root.delete(15);
        System.out.println("In-order traversal after deleting 15:");
        root.inOrderTraversal(); // Should print: 3 5 7 10 12 17
        System.out.println();
    }
}
