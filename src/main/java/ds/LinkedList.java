package ds;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node node = new Node(value);
        head = node;
        tail = node;
        this.length = 1;
    }

    public void reverse(){
        Node current = head;
        head = tail;
        tail = current;

        Node before = null;
        for (int i = 0; i < length; i++) {
            Node after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
    }

    public Node remove(int index){
        if (index < 0 || index >= length){
            return null;
        }
        if (index == 0){
            return removeFirst();
        }
        else if (index == length - 1){
            return removeLast();
        }
        Node prev = get(index - 1);
        Node nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
        nodeToRemove.next = null;
        length--;
        return nodeToRemove;
    }

    public boolean set(int index, int value){
        Node node = get(index);
        if (node != null){
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }
        if (index == 0){
            prepend(value);
            return true;
        }
        else if (index == length ){
            append(value);
            return true;
        }
        Node node = new Node(value);
        Node temp = get(index-1);
//      Node temp = head;
//      for (int i = 0; i < index-1; i++) {
//          temp = temp.next;
//      }
        node.next = temp.next;
        temp.next = node;
        length++;
        return true;
    }

    public Node get(int index){
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node removeFirst(){
        if (length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        length++;
    }

    public void append(int value){
        Node node = new Node(value);
        if (length == 0){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public String toString(){
        Node temp = head;
        StringBuilder result = new StringBuilder("[");
        while (temp != null){
            result.append(temp.value);
            if (temp.next != null){
                result.append(", ");
            }
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }

    public Node getHead(){
        return this.head != null? this.head : null;
    }

    public Node getTail(){
        return this.tail != null ? this.tail : null;
    }

    public int getLength(){
        return this.length;
    }

    class Node {
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }

        public String toString(){
            return String.valueOf(value);
        }
    }
}