package Hot100.Medium;

import Hot100.Easy.ListNode;

public class TestSolution {
    public static void main(String args[]){
        /*ListNode L11 = new ListNode(2);
        ListNode L12 = new ListNode(4);
        ListNode L13 = new ListNode(3);
        L11.next = L12;
        L12.next = L13;

        ListNode L21 = new ListNode(5);
        ListNode L22 = new ListNode(6);
        ListNode L23 = new ListNode(4);
        L21.next = L22;
        L22.next = L23;*/
        //----------
       /* ListNode L11 = new ListNode(0);
        ListNode L21 = new ListNode(1);*/
        //----
       /* ListNode L11 = new ListNode(9);

        ListNode L210 = new ListNode(9);
        ListNode L29 = new ListNode(9,L210);
        ListNode L28 = new ListNode(9,L29);
        ListNode L27 = new ListNode(9,L28);
        ListNode L26 = new ListNode(9,L27);
        ListNode L25 = new ListNode(9,L26);
        ListNode L24 = new ListNode(9,L25);
        ListNode L23 = new ListNode(9,L24);
        ListNode L22 = new ListNode(9,L23);
        ListNode L21 = new ListNode(1,L22);

        System.out.println("see L210");
        L21.traverListRightHere();
        System.out.println();
*/
        ListNode L17 = new ListNode(9);
        ListNode L16 = new ListNode(9,L17);
        ListNode L15 = new ListNode(9,L16);
        ListNode L14 = new ListNode(9,L15);
        ListNode L13 = new ListNode(9,L14);
        ListNode L12 = new ListNode(9,L13);
        ListNode L11 = new ListNode(9,L12);

        ListNode L24 = new ListNode(9);
        ListNode L23 = new ListNode(9,L24);
        ListNode L22 = new ListNode(9,L23);
        ListNode L21 = new ListNode(9,L22);


        SolutionTowNumSumInList so1 = new SolutionTowNumSumInList();
        ListNode ans =  so1.addTwoNumbers(L11,L21);
        ans.traverListRightHere();
        return;

    }
}
