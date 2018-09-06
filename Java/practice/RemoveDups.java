package practice;

import java.util.HashSet;

public class RemoveDups {
    public static void main(String []args) throws Exception {
        if(args.length == 0) {
            System.out.println("Insufficient Inputs");
        }

        int n = Integer.parseInt(args[0]);
        ListNode head = null;

        for(int i = 0; i < n; i++) {
            head = new ListNode(Integer.parseInt(args[i+1]), head);
        }

        printList(head);

        HashSet<Integer> set = new HashSet<>();

        ListNode traveller = head;
        ListNode follower = head;

        while(traveller != null) {
            if(set.contains(new Integer(traveller.val))) {
                follower.next = traveller.next;
            } else {
                set.add(new Integer(traveller.val));
                follower = traveller;
            }
            traveller = traveller.next;
        }

        printList(head);
    }

    static void printList(ListNode head) {
        ListNode traveller = head;

        while(traveller != null) {
            System.out.print(traveller.val + " ");
            traveller = traveller.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
