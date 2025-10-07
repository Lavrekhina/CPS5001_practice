package week_3_stacks_and_queues.NewQueue;

public class LinkedListNode {
    private int value;
    private LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListNode(int value, LinkedListNode next){
        this.value = value;
        this.next = next;
    }
    public int getValue(){
        return value;
    }

    public LinkedListNode getNext(){
        return next;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setNext(LinkedListNode next){
        this.next = next;
    }

}
