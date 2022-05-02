package ACMmodel.TenCent;


import java.util.HashMap;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

//初步写完未测试
public class MainRedo4 {
    public static void main(String[] args) {


    }

    public ListNode solve(ListNode[] a) {
        HashMap<Integer, ListNode> preMap = new HashMap<>();
        HashMap<Integer, ListNode> nextMap = new HashMap<>();
        HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        int min = 0x3f3f3f3f;
        for (int i = 0; i < a.length; i++) {
            ListNode cur = a[i];
            nodeMap.put(cur.val, cur);
            if (!preMap.containsKey(cur.val)) {
                preMap.put(cur.val, null);
            }

            if (cur.val < min) min = cur.val;
            while (cur.next != null) {
                nextMap.put(cur.val, cur.next);
                ListNode pre = cur;
                cur = cur.next;
                preMap.put(cur.val, pre);
                nodeMap.put(cur.val, cur);//重复没关系
                if (cur.val < min) min = cur.val;
            }
            if (!nextMap.containsKey(cur.val)) {
                nextMap.put(cur.val, null);
            }
        }
        ListNode t1 = null, t2 = null;
        for (int e : preMap.keySet()
        ) {
            if (preMap.get(e) == null) {
                t1 = nodeMap.get(e);
            }
        }
        for (int e : nextMap.keySet()) {
            if (nextMap.get(e) == null) {
                t2 = nodeMap.get(e);
            }
        }
        if (t1 != null && t2 != null) {
            preMap.put(t1.val, t2);
            nextMap.put(t2.val, t1);
        }
        //看看是正序还是逆序
        int direction = 0;
        int s1 = min, s2 = min;
        while (s1 == s2) {
            s1 = preMap.get(s1).val;
            s2 = nextMap.get(s2).val;
        }
        if (s1 < s2) direction = -1;
        else direction = -2;

        ListNode head = new ListNode(0);
        ListNode scanNode = nodeMap.get(min);
        head.next = scanNode;
        //逆序遍历
        int scan = min;
        if (direction <= 0 && scanNode.next != head.next) {
            scanNode.next = preMap.get(scan);
            scanNode = scanNode.next;
            scan = scanNode.val;
        }
        if (direction <= 0 && scanNode.next != head.next) {
            {//正向遍历
                scanNode.next = nextMap.get(scan);
                scanNode = scanNode.next;
                scan = scanNode.val;
            }

        }
        return head.next;
    }
}
