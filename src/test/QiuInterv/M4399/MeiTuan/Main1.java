package test.QiuInterv.M4399.MeiTuan;
import java.util.*;
class Node{
    int val;
    Node next;
    public Node(int val,Node next){
        this.val =val;
        this.next = next;
    }
}

public class Main1 {
    public static void main(String[] args) {

        Node one = new Node(2,null);
        Node two = new Node(1,null);
        Node three = new Node(3,null);
        Node four = new Node(2,null);
        Node five = new Node(0,null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Node sortedHead = linkedListSort(one);
        Node scan = sortedHead;

        while(scan !=null){
            System.out.println(scan.val+" ");
            scan =scan.next;

        }



    }
    public static Node linkedListSort(Node head){
        //先分后合
        //分的边界
        if(head.next == null) return head;
        //寻找分中间点，因为不是数组，不能直接得到
        int len = 0;
        Node scan = head;
        while(scan!=null){
            len++;
            scan = scan.next;
        }
        int cou = 0;
        scan = head;
        while(cou!= len/2-1){ // len = 5
            scan = scan.next;
            cou++;
        }
        Node rightHead = scan.next;
        scan.next = null;
        Node pl  = linkedListSort(head);
        Node pr = linkedListSort(rightHead);
        //分结束

        //开始合
        Node virtulHead = new Node(-1,null);
        Node ptr = virtulHead;

       /* Node pl = head;
        Node pr = rightHead;*/

        while(pl!=null && pr !=null){
            if(pl.val < pr.val){
                ptr.next = pl;
                pl = pl.next;
            }else{
                ptr.next = pr;
                pr = pr.next;
            }
            ptr = ptr.next;
        }
        while(pl!=null){
            ptr.next = pl;
            pl = pl.next;
            ptr = ptr.next;
        }
        while(pr!=null){
            ptr.next = pr;
            pr = pr.next;
            ptr = ptr.next;
        }
        return virtulHead.next;

    }
}
