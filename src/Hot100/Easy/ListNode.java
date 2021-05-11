package Hot100.Easy;

//Definition for singly-linked list.

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public void traverListRightHere(){
        ListNode p = new ListNode(val,next);
        ListNode scan = p.next;
        while(p != null){
            System.out.print(p.val+"->");
            p = scan;
            if(scan != null)scan = scan.next;
        }
    }
}
