package ACMmodel.ByteDance;

import java.util.Scanner;
/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */


public class RotateKList {

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        Node head = new Node(-1, null);
        Node scan = head;

        for (int i = 0; i < len; i++) {
            int curVal = sc.nextInt();
            Node curNode = new Node(curVal, null);
            scan.next = curNode;
            scan = scan.next;
        }
        sc.nextLine();

        head.next =  rotateK(head.next, k);
        //输出
        scan = head.next;
        while(scan!=null){
            System.out.print(scan.val);
            if(scan.next != null) System.out.print(" ");
            scan = scan.next;
        }
        System.out.println();
    }

    //头插法改变顺序--递归来实现控制
    //该方法执行一次，仅仅旋转head及其后面k个节点
    /**返回旋转后的第一个节点*/
    public static Node rotateK(Node head, int k) {
        //判断是否可以完成当次旋转
        int resLen = 0;
        Node scan = head;
        while (scan != null) {
            resLen++;
            if (resLen >= k) break;
            scan = scan.next;
        }
        if(resLen >= k) { //做旋转
            Node vHead = new Node(-1, head);
            int cou = 0;
            scan = head;
            Node nextNode = scan.next;
//            Node tail = scan;
            while (cou < k) {
                scan.next = vHead.next;
                vHead.next = scan;
                scan = nextNode;
                //len%k == 0 的情况肯会有空指针异常： nextNode = nextNode.next;
                nextNode = nextNode == null? null :nextNode.next;
                cou++;
            }
            //开始的 head 成为旋转后的 tail!!
            head.next  = rotateK(scan,k);
            //要返回的是 新head
            return vHead.next;

            //return
        }

        //长度不够，直接返回，不需要旋转
        return head;
    }

}
