package practice;

import java.util.Set;
import java.util.HashSet;

class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}


public class LinkedList {
    Node head;

    public boolean insert(int value) {
        if(head == null) {
            head = new Node(value, head);
        }

        Node traveller = head;
        while(traveller.next != null) {
            traveller = traveller.next;
        }

        traveller.next = new Node(value, traveller.next);
        return true;
    }

    public boolean delete(int value) {
        Node traveller = head;
        Node follower = head;

        while(traveller != null && traveller.value != value) {
            follower = traveller;
            traveller = traveller.next;
        }

        if(traveller == null)
            return false;
        if(traveller == head) {
            head = head.next;
        } else {
            follower.next = traveller.next;
        }

        return true;
    }

    public void printList() {
        Node traveller = head;

        while(traveller != null) {
            System.out.print(traveller.value + "->");
            traveller = traveller.next;
        }
        System.out.println("null");
    }

    public void removeDups() {
        Set<Integer> set = new HashSet<Integer>();
        Node traveller = head;
        Node follower = traveller;

        while(traveller != null) {
            if(set.add(new Integer(traveller.value))) {
                follower = traveller;
                traveller = traveller.next;
            } else {
                follower.next = traveller.next;
                traveller = traveller.next;
            }
        }
    }


    public static void main(String []args) {
        LinkedList ll = new LinkedList();
        ll.insert(2);
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(2);

        ll.printList();

        ll.removeDups();

        ll.printList();
    }
}
