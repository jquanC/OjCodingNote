package Qiu.Tencent;

import Hot100.Easy.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Main1 {
    int len1 = 0;
    int len2 = 0;
    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        ListNode rb = revertList(b);
        ListNode scan = a;
        while(scan!=null){
            len1++;
            scan = scan.next;
        }

        if(len1>len2){
            int cou = 1;
            scan = a;
            while(cou!=len1-len2){
                cou++;
                scan = scan.next;
            }
            scan.next =  xorEqualLenList(scan.next,rb);
            while(a!=null && a.val == 0){
                a = a.next;
            }
            return a;

        }else if(len1 == len2){
            ListNode newMerge =  xorEqualLenList(a,rb);
            while(newMerge!=null && newMerge.val == 0){
                newMerge = newMerge.next;
            }
            return newMerge;

        }else{
            int cou = 1;
            scan = rb;
            while(cou!=len2-len1){
                cou++;
                scan = scan.next;
            }
            scan.next = xorEqualLenList(a,scan.next);
            while(rb!=null && rb.val == 0){
                rb = rb.next;
            }

            return rb;
        }


    }
    public ListNode revertList(ListNode head){
        ListNode vir = new ListNode(-1);
        ListNode scan  = head;
        while(scan !=null){
            len2++;
            ListNode nextNode = scan.next;
            scan.next = vir.next;
            vir.next = scan;
            scan = nextNode;
        }
        return vir.next;
    }
    public ListNode xorEqualLenList(ListNode a,ListNode b){
        ListNode vir = new ListNode(-1);
        vir.next = a;
        while(a!=null && b!=null){
            if(a.val == b.val) a.val = 0;
            else a.val = 1;
            a = a.next;
            b = b.next;
        }
        return vir.next;

    }
}
