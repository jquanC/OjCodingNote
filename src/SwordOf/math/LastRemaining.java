package SwordOf.math;

import org.junit.Test;

public class LastRemaining {
    /**环形链表 */
    public int lastRemaining(int n, int m) {

        //初始化环形单链表
        ListNode head = new ListNode(0);
        ListNode curNode = head;

        for(int i=1;i<n;i++){
            ListNode newNode = new ListNode(i);
            curNode.next = newNode;
            newNode.pre = curNode;
            curNode = curNode.next;
        }
        int size = n;
        ListNode tail = curNode;
        tail.next = head;
        head.pre = tail;

        //开始删除 每次从cur开始移动(m-2)步

        curNode = head;
        int deleteCou = n-1;
        while(deleteCou!=0){
            int move = m%size;
            while(move>1){
                curNode = curNode.next;
                move--;
            }
            //删除 求余后move=0 是要删除当前链表最末尾元素，需要特殊处理
            if(move == 0 ){
                curNode = curNode.pre;//移动指针，把两种情况统一一下
            }

            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
            curNode = curNode.next;
            deleteCou--;
            size--;
        }
        return curNode.val;
    }


    //第一环形单链表数据结构
    class ListNode{
        public int val;
        public ListNode next;
        public ListNode pre;
        public ListNode(int val,ListNode next,ListNode pre){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }

        public ListNode(int val){
            this.val = val;
        }
        public ListNode(){}
    }

    @Test
    public void test(){
        int res = lastRemaining(70866,116922);
        System.out.println(res);
    }
}
