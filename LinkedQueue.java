package datastructures;

/**
 * Created by vijaya on 3/6/2017.
 */
public class LinkedQueue {
    Node head = new Node(null);
    Node last = head;

    public void add(Object obj) {
        Node newNode = new Node(obj);
        last.next = newNode;
        last = newNode;
    }

    public Object get() {

        Object object =null;
        if(head.next!=null) {
            head = head.next;
            object = head.data;
            head.data = null;
        }
        return object;
    }

    public String toString() {
        String str = new String();
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
            str = str + "|" + current.data;
        }
        return str;
    }


    class Node {
        Object data = null;
        Node next = null;
        public Node(Object data) {
            this.data = data;
        }

        public String toString() {
            return "Data = " + data + ", next = " + next;
        }

    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        System.out.println(queue);
        queue.add("1");
        System.out.println(queue);
        queue.add("2");
        System.out.println(queue);
        queue.add("3");
        System.out.println(queue);
        queue.add("4");
        System.out.println(queue);
        queue.get();
        System.out.println(queue);
        queue.get();
        System.out.println(queue);
        queue.get();
        System.out.println(queue);
        queue.get();
        System.out.println(queue);
        queue.get();
        System.out.println(queue);
        queue.add("1");
        System.out.println(queue);
        queue.add("2");
        System.out.println(queue);

    }
}