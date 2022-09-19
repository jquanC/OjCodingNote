package Qiu.Oppo;

import Hot100.Easy.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        ListNode f1 = new ListNode(3);
        ListNode f2 = new ListNode(4);
        ListNode f3 = new ListNode(1);

        ListNode d1 = new ListNode(5);
        ListNode d2 = new ListNode(6);
        ListNode d3 = new ListNode(2);

        f1.next = f2;
        f2.next = f3;
        d1.next = d2;
        d2.next = d3;

        Main2  so = new Main2();
        ListNode ans =  so.combineTwoDisorderNodeToOrder(f1,d1);
        while (ans!=null){
            System.out.println(ans.val+" ");
            ans = ans.next;
        }

    }
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        ArrayList<ListNode> list = new ArrayList();
        ListNode scan1 = node1;
        ListNode scan2 = node2;
        while(scan1!=null){
            list.add(scan1);
            scan1 = scan1.next;
        }
        while(scan2!=null){
            list.add(scan2);
            scan2 = scan2.next;
        }
        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode virHead = new ListNode(-1);
        ListNode preNode = virHead;

        for(int i=0;i<list.size();i++){
            ListNode e = list.get(i);
            preNode.next = e;
            preNode = e;
            if(i==list.size()-1) e.next = null;

        }
        return virHead.next;

    }
}
