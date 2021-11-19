package SwordOf.list;

import SwordOf.domain.ListNode;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode scanA = headA;
        ListNode scanB = headB;

        while(scanA!=null){
            lenA++;
            scanA = scanA.next;
        }
        while(scanB!=null){
            lenB++;
            scanB = scanB.next;
        }
        ListNode scanLong;
        ListNode scanShort;
        int dif =0;
        if( lenA>lenB ){
         dif = lenA-lenB;
         scanLong = headA;
         scanShort = headB;
        }else{
            dif = lenB-lenA;
            scanLong = headB;
            scanShort = headA;
        }

        while(dif>0){
            scanLong = scanLong.next;
            dif--;
        }
        while(scanLong!=scanShort){
            scanLong = scanLong.next;
            scanShort = scanShort.next;
        }
        return scanLong;

    }


}
