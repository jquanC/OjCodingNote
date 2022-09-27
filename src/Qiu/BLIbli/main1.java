package Qiu.BLIbli;

import Hot100.Easy.ListNode;

import java.util.ArrayList;

public class main1 {
    public ListNode longestList (ListNode head) {
        // write code here
        ArrayList<Integer> ans1 = new ArrayList();
        ArrayList<Integer> ans2 = new ArrayList();

        ListNode scan = head;
        ListNode firOU = null;
        if(scan.val %2 ==0){//选择第一个结点是偶数
            firOU = scan;
            ans1.add(scan.val);
            recurChoose(scan,scan.next,ans1);
        }
        ListNode firJi = null;
        while(scan!=null && scan.val %2==0) scan = scan.next;
        if(scan!=null){
            firJi = scan;
            ans2.add(scan.val);//選擇第一個節點是奇數
            recurChoose(scan,scan.next,ans2);
        }
        ListNode virHead = new ListNode();
        if(ans1.size()>ans2.size()){
            virHead.next = firOU;
            recurDelete(firOU,firOU.next);
        }else{
            virHead.next = firJi;
            recurDelete(firJi,firJi.next);
        }
        return virHead.next;
    }
    //没必要真的删除
    public void recurChoose(ListNode pre,ListNode cur, ArrayList<Integer> ans){
        if(cur==null) return;

        if(pre.val%2==0){
            while(cur!=null && cur.val%2==0){
                cur = cur.next;
            }
            if(cur!=null){
                ans.add(cur.val);
                recurChoose(cur,cur.next,ans);
            }
        }else{
            while(cur!=null && cur.val%2==1){
                cur = cur.next;
            }
            if(cur!=null){
                ans.add(cur.val);
                recurChoose(cur,cur.next,ans);
            }
        }
    }
    public void recurDelete(ListNode pre,ListNode cur){

        if(cur==null) return;

        if(pre.val%2==0){
            while(cur!=null && cur.val%2==0){
                cur = cur.next;
            }
            pre.next = cur;
            if(cur == null) return;
            recurDelete(cur,cur.next);
        }else{
            while(cur!=null && cur.val%2==1){
                cur = cur.next;
            }
            pre.next = cur;
            if(cur == null) return;
            recurDelete(cur,cur.next);

        }

    }
}
