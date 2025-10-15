package week_4_Trees;

public class RedBlackTree {

    private Node root;
    private final Node TNULL;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    // Node structure
    private class Node {
        int data;
        boolean color;
        Node left, right, parent;

        Node(int data) {
            this.data = data;
            this.color = RED; // new node is red by default
            this.left = this.right = this.parent = TNULL;
        }
    }

    // Constructor
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = BLACK;
        TNULL.left = TNULL.right = TNULL.parent = TNULL;
        root = TNULL;
    }

    // Preorder traversal helper
    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.data + (node.color == RED ? "R " : "B "));
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    public void preOrder() {
        preOrderHelper(this.root);
        System.out.println();
    }

    // Search the tree
    private Node searchTreeHelper(Node node, int key) {
        if (node == TNULL || key == node.data) {
            return node;
        }
        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }

    public boolean search(int key) {
        Node node = searchTreeHelper(this.root, key);
        return node != TNULL;
    }

    // Left rotate
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == TNULL) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Right rotate
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == TNULL) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Insert a node
    public void insert(int key) {
        Node node = new Node(key);
        node.left = node.right = node.parent = TNULL;

        Node y = TNULL;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == TNULL) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        // if new node is a root node, simply color it black and return
        if (node.parent == TNULL) {
            node.color = BLACK;
            return;
        }

        if (node.parent.parent == TNULL) {
            return;
        }

        // Fix the tree
        fixInsert(node);
    }

    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == RED) {
            if (k.parent == k.parent.parent.left) {
                u = k.parent.parent.right; // uncle
                if (u.color == RED) {
                    // case 1
                    k.parent.color = BLACK;
                    u.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // case 2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // case 3
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rightRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.left; // uncle
                if (u.color == RED) {
                    // mirror case 1
                    k.parent.color = BLACK;
                    u.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // mirror case 2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // mirror case 3
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    leftRotate(k.parent.parent);
                }
            }
            if (k == root) break;
        }
        root.color = BLACK;
    }

    // Transplant subtrees u -> v
    private void rbTransplant(Node u, Node v) {
        if (u.parent == TNULL) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    // Find the minimum node starting from given node
    private Node minimum(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    // Delete a node by key
    public void delete(int key) {
        deleteNodeHelper(this.root, key);
    }

    private void deleteNodeHelper(Node node, int key) {
        Node z = TNULL;
        Node x, y;
        while (node != TNULL) {
            if (node.data == key) {
                z = node;
            }
            if (node.data <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (z == TNULL) {
            // Key not found
            return;
        }

        y = z;
        boolean yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == BLACK) {
            fixDelete(x);
        }
    }

    // Fix the RB tree after deletion
    private void fixDelete(Node x) {
        Node s;
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == RED) {
                    s.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == BLACK && s.right.color == BLACK) {
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (s.right.color == BLACK) {
                        s.left.color = BLACK;
                        s.color = RED;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.right.color = BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == RED) {
                    s.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.left.color == BLACK && s.right.color == BLACK) {
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (s.left.color == BLACK) {
                        s.right.color = BLACK;
                        s.color = RED;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    // Main for quick test
    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();
        bst.insert(55);
        bst.insert(40);
        bst.insert(65);
        bst.insert(30);
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);

        System.out.println("Preorder traversal (value + color):");
        bst.preOrder(); // Output the preorder traversal

        System.out.println("Search for 50: " + bst.search(50));
        System.out.println("Search for 100: " + bst.search(100));

        System.out.println("Deleting 40...");
        bst.delete(40);
        bst.preOrder();
    }
}
