package week_1.plantwateringsystem.Circular_Linked_List;

public class CircularNode {
    int data;
    CircularNode next;

    public CircularNode(int data) {
        this.data = data;
        this.next = this; // initially points to itself
    }
}

