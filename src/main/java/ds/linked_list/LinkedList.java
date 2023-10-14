package ds.linked_list;

import java.util.NoSuchElementException;

/**
 * Singly LinkedList Implementation
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node node = new Node(value);
        head = tail = node;
        length = 1;
    }

    public LinkedList(){
        head = tail = null;
        length = 0;
    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    public Node remove(int index){
        if (index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
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

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            throw new  IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (index == 0){
            prepend(value);
        }
        else if(index == length){
            append(value);
        }else{
            Node node = new Node(value);
            Node prev = get(index - 1);
            node.next = prev.next;
            prev.next = node;
        }
        length++;
        return true;
    }

    public boolean set(int index, int value){
        Node node = get(index);
        if (node == null){
            throw new NoSuchElementException("Index is out of bounds");
        }
        node.value = value;
        return true;
    }

    public Node get(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void append(int value){
        Node node = new Node(value);
        if (isEmpty()){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if (isEmpty()){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("inthe LinkedList is empty");
        }
        Node first = head;
        head = head.next;
        first.next = null;
        length--;
        if (isEmpty()){
            head = tail = null;
        }
        return first;
    }

    public Node removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("inthe LinkedList is empty");
        }

        Node last = head;
        Node pre = head;
        while (last.next != null){
            pre = last;
            last = last.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            head = tail = null;
        }
        return last;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    public String getDetails(){
        return "\nHEAD: " + this.head + "\n" +
                "intAIL: " + this.tail + "\n"+
                "LENGintH: " + this.length + "\n";
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp != null){
            result.append(temp.value);
            if (temp.next != null){
                result.append(" -> ");
            }
            temp = temp.next;
        }
        return result.toString();
    }

    private class Node{
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