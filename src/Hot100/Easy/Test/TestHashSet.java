package Hot100.Easy.Test;

import Hot100.Easy.ListNode;

import java.util.HashSet;

import java.util.Set;

public class TestHashSet {
    public static void main(String args[]){
        Set<ListNode> see = new HashSet<ListNode>();

        ListNode h1 = new ListNode(1);
        System.out.println(see.add(h1));
        ListNode h2 = new ListNode(2);
        h1.val = 2;
        System.out.println(see.add(h2));
        System.out.println(see.add(h1));

        ListNode h3 = new ListNode(1);
        System.out.println(see.add(h3));
        //这里*默认* hashcode 怎么计算的？ 通过Object 对象 计算，Objetc 对象的状态改了，但还是原来那么Object对象，则还是无法添加
        /*对于ListNode 结点来说
        hashcode 是什么？怎么计算（默认）？HashCode是一个Int型的值，其所代表的是给对应元素分配的内存地址
        key是什么？
        key 和 hashcode 的关系？
        value 是什么？
        * */



    }
}
