package ds;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(T value){
        Node<T> node = new Node<>(value);
        head = tail = node;
        length = 1;
    }

    public LinkedList(){
        head = tail = null;
        length = 0;
    }

    public void reverse(){
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    public Node<T> remove(int index){
        if (index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        if (index == 0){
            return removeFirst();
        }
        else if (index == length - 1){
            return removeLast();
        }
        Node<T> prev = get(index - 1);
        Node<T> nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
        nodeToRemove.next = null;
        length--;
        return nodeToRemove;
    }

    public boolean insert(int index, T value){
        if(index < 0 || index > length){
            throw new  IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (index == 0){
            prepend(value);
        }
        else if(index == length){
            append(value);
        }else{
            Node<T> node = new Node<>(value);
            Node<T> prev = get(index - 1);
            node.next = prev.next;
            prev.next = node;
        }
        length++;
        return true;
    }

    public boolean set(int index, T value){
        Node<T> node = get(index);
        if (node == null){
            throw new NoSuchElementException("Index is out of bounds");
        }
        node.value = value;
        return true;
    }

    public Node<T> get(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void append(T value){
        Node<T> node = new Node<>(value);
        if (isEmpty()){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void prepend(T value){
        Node<T> node = new Node<>(value);
        if (isEmpty()){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node<T> removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("The LinkedList is empty");
        }
        Node<T> first = head;
        head = head.next;
        first.next = null;
        length--;
        if (isEmpty()){
            head = tail = null;
        }
        return first;
    }

    public Node<T> removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("The LinkedList is empty");
        }

        Node<T> last = head;
        Node<T> pre = head;
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
                "TAIL: " + this.tail + "\n"+
                "LENGTH: " + this.length + "\n";
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node<T> temp = head;
        while (temp != null){
            result.append(temp.value);
            if (temp.next != null){
                result.append(" -> ");
            }
            temp = temp.next;
        }
        return result.toString();
    }

    private class Node<T>{
        Node<T> next;
        T value;
        public Node(T value){
            this.value = value;
        }
        public String toString(){
            return String.valueOf(value);
        }
    }
}