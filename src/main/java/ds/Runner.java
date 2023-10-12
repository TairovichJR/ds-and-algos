package ds;

public class Runner {

    public static void main(String[] args) {

        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);

        System.out.println(list);

        list.reverse();

        System.out.println(list);

        System.out.println("======================");
        System.out.println("Head: " + list.getHead());
        System.out.println("Tail: " + list.getTail());
        System.out.println("Length: " + list.getLength());
        System.out.println("=======================");

    }
}
