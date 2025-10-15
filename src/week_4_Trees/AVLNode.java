package week_4_Trees;

class AVLNode {
    int key, height;
    AVLNode left, right;

    public AVLNode(int key) {
        this.key = key;
        this.height = 1; // New node starts as a leaf
    }
}

