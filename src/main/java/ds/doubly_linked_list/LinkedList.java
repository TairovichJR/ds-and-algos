package ds.doubly_linked_list;

/**
 * Doubly LinkedList implementation
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(){
        head = tail = null;
        length = 0;
    }
    public LinkedList(int value) {
        Node node = new Node(value);
        head = tail = node;
        length = 1;
    }

    public void append(int value){
        Node node = new Node(value);
        if (length == 0){
            head = tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }


    private class Node{
        Node next;
        Node prev;
        int value;
        public Node(int value) {
            this.value = value;
        }
    }
}
