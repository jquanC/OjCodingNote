package Hot100.Medium;

public class S050PreMergeTwoLinkedList {
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2==null) return null;
        if(l1 ==null||l2==null) return l1==null?l2:l1;

        ListNode dumbHead = new ListNode(), cur=dumbHead, scan1 = l1, scan2 = l2;

        while (scan1 != null || scan2 != null) { //进入时，都不为Null

            if(scan1.val<=scan2.val){
                cur.next  = scan1;
                cur = cur.next;
                scan1 = scan1.next;
            }else{
                cur.next  = scan2;
                cur = cur.next;
                scan2 = scan2.next;
            }

            while(scan1==null&& scan2 != null){ //其一为null
                cur.next = scan2;
                cur = cur.next;
                scan2 = scan2.next;
            }
            while(scan2==null&& scan1 != null){//其一为null
                cur.next = scan1;
                cur = cur.next;
                scan1 = scan1.next;
            }


        }
        return dumbHead.next;
    }*/

    //更加简化的逻辑？
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1==null || l2 ==null) return l1 == null? l2 :l1;

        ListNode dumbHead = new ListNode(), cur=dumbHead, scan1 = l1, scan2 = l2;
        while(scan1 != null && scan2 !=null){
            if(scan1.val<=scan2.val){
                cur.next = scan1;
                cur = cur.next;
                scan1 = scan1.next;
            }else{
                cur.next = scan2;
                cur = cur.next;
                scan2 = scan2.next;
            }
        }
        if(scan1 == null) cur.next = scan2;
        else cur.next = scan1;

        return dumbHead.next;
    }
}
