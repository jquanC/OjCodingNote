package Hot100.Easy.Test;

import Hot100.Easy.ListNode;

public class TestNullPointExcept {
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

        ListNode p1 = l1.next.next;
        ListNode p2 = l2.next.next;

        //运行报错


    }

}
