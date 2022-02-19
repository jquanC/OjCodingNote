package Hot100.Test;

import Hot100.Medium.DP.NumSquares;
import Hot100.Medium.ListNode;
import Hot100.Medium.S052RobDP;
import Hot100.Medium.So50SortedLinkedList;
import org.junit.Test;

public class TestOJ {
    @Test
    public void testSortList(){
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(0);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next =five;

        So50SortedLinkedList so = new So50SortedLinkedList();
        ListNode sortedList = so.sortList(one);
        sortedList.traverListRightHere();

    }
    @Test
    public void testS052RobDP(){
        int[]nums = new int[]{1,2,3,1};
        S052RobDP so52RobDP = new S052RobDP();
         int res = so52RobDP.rob(nums);
        System.out.println(res);
    }
    @Test
    public void testNumSquares(){
        int n = 13;
        NumSquares soNumSquare = new NumSquares();
        int res = soNumSquare.numSquares(n);
        System.out.println(res);
    }
    @Test
    public void testStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("a");
        sb.append("a");
        sb.append("a");
        String r = sb.substring(0,0);
        String e = sb.substring(4,4);
        System.out.println(r);
        System.out.println(e);
        String test = "aaaa";
        String f = test.substring(0,0);
        String g = test.substring(4,4);
        System.out.println(f);
        System.out.println(g);
        System.out.println(f==null);
        System.out.println(f.equals(""));

    }

}
