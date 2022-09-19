package Qiu.Mi;


import javax.swing.*;
import java.util.List;

class ListNode<T> {
    public T data;
    public ListNode next;
}

public class Main1 {
    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) { //1 2
        if(left == right) return  head;
        int cou = 1;
        ListNode<Integer> virHead = new ListNode();
        ListNode<Integer> scan = virHead;
        virHead.next = head;

        while(cou!=left){
            scan = scan.next;
            cou++;
        }
        ListNode<Integer> storePoint = scan;
        scan = scan.next;
//        cou++;
        //下一个是要翻转的节点，开始反转
        ListNode<Integer> subRevHead = new ListNode();
        ListNode<Integer> tailPoint = new ListNode<>();
        boolean tail = false;
        while(cou<=right){
            ListNode<Integer> next = scan.next;
            scan.next = subRevHead.next;
            subRevHead.next = scan;
            if(!tail){
                tail = true;
                tailPoint = scan;
            }
            cou++;
            scan = next;
        }
        storePoint.next = subRevHead.next;
        tailPoint.next = scan;
        return head;

    }
}
