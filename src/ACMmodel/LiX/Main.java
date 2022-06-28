package ACMmodel.LiX;

import Hot100.Easy.ListNode;

public class Main {
    public static void main(String[] args) {


    }

    public static ListNode mergeV2(ListNode h1, ListNode h2) {
        ListNode newHead = new ListNode();

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                if (h1.val != newHead.val) {
                    newHead.next = h1;
//                    h1 = h1.next;
                    newHead = newHead.next;
                }
                h1 = h1.next;


            } else {
                if (h2.val != newHead.val) {
                    newHead.next = h2;
                    newHead = newHead.next;
                }
                h2 = h2.next;
            }
//            newHead = newHead.next;
        }
        while (h1 != null) {
            if (newHead.val != h1.val) {
                newHead.next = h1;
                newHead = newHead.next;
            }
            h1 = h1.next;

        }
        while (h2 != null) {
            if (newHead.val != h2.val) {
                newHead.next = h2;
                newHead = newHead.next;
            }
            h2 = h2.next;
        }
        return newHead.next;
    }

    /**
     * newHead
     * preHead
     */
    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode newHead = new ListNode();

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                newHead.next = h1;
                h1 = h1.next;
            } else {
                newHead.next = h2;
                h2 = h2.next;
            }
            newHead = newHead.next;
        }
        while (h1 != null) {
            newHead.next = h1;
            newHead = newHead.next;
            h1 = h1.next;
        }
        while (h2 != null) {
            newHead.next = h2;
            newHead = newHead.next;
            h2 = h2.next;
        }
        return newHead.next;
    }
}
