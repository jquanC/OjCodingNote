# SwordOf

## 栈和队列

### [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

````text
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )


示例 1：


输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

````

````java
package SwordOf.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
       inStack.push(value);

    }

    public int deleteHead() {
        if(inStack.isEmpty() && outStack.isEmpty()) return -1;

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                int val = inStack.pop();
                outStack.push(val);
            }
        }
        return  outStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
````

**复杂度**

- **时间复杂度是：$O(1)$**，插入显然是, 对于删除队尾的操作，也是O（1）.**每个元素只需要进入，弹出栈2一次，均摊分析可证**、



### [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

````text
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
 
提示：

各函数的调用总次数不超过 20000 次

````

**思路**

- 用一个辅助栈，存储当前对应于栈的最小元素即可。可见，在栈的题目中，辅助栈经常用

````java
package SwordOf.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) minStack.push(x);
        else{
            int com = minStack.peek();
            int val = stack.peek();
            minStack.push(val < com? val: com);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {

        return minStack.peek();

    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

````



## 链表

### [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

````text
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 
````

**思路**

- 最直接是用一个栈
- 我的解法是建一个反转链表，都可以

````java
package SwordOf.list;

import SwordOf.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**其实用栈就好*/
public class reversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];

        ListNode scan = head;
        ListNode reverseHead = new ListNode(-1);

        /*尾插法得到新的反转链表*/
        int len = 0;
        while (scan != null) {
            ListNode node = new ListNode(scan.val);
            node.next = reverseHead.next;
            reverseHead.next = node;
            scan = scan.next;
            len++;
        }
        int[] res = new int[len];
        scan = reverseHead.next;
        for (int i = 0; i < len; i++) {
            if (scan != null) {
                res[i] = scan.val;
                scan = scan.next;
            }
        }
        return res;
    }
}

````



### [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

````text
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000

````

**思路**

- 反转链表的解法如上一题，这里直接在原链表反转即可
- **注意递归解法**-从后往前一个个改
  - <img src="mdPics/image-20211026110331677.png" alt="image-20211026110331677" style="zoom: 67%;" />
  - <img src="mdPics/image-20211026111306551.png" alt="image-20211026111306551" style="zoom:67%;" />

````java
package SwordOf.list;

import SwordOf.domain.ListNode;

public class reverseListSo {
    /**在原来链表的基础上反转就可以了*/
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = new ListNode(0);
        ListNode scan = head;

        if(head == null) return head;

        while(scan != null){
            ListNode next = scan.next;
            scan.next = reverseHead.next;
            reverseHead.next = scan;
            scan = next;
        }
        return reverseHead.next;

    }
}



package SwordOf.list;

import SwordOf.domain.ListNode;
/**递归方法反转链表*/
public class reverseListRecursionSo {

    public ListNode reverseList(ListNode head) {
       if(head ==null || head.next ==null) return head;

       ListNode newHead = reverseList(head.next);
       head.next.next = head; //修改方向
       head.next = null;//为了避免成环；不用担心丢失连接信息；对于前面原序的链表，前面node的next还指向该head

        return  newHead;

    }
}

````

### *[剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

````text
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

<img src="mdPics/image-20211027105807455.png" alt="image-20211027105807455" style="zoom:67%;" />

**思路**

- 题目的关键是如何copy random指针，因为random指针是随机的
- 我的解法，两个HashMap<Node,id> Hash<id,Node>来维护这个关系，$O(n),O(n)$ ,比较常规的思路
- 参考解1：显然适合用回溯（递归）做，到最深处时，所有的结点都已经被复制出来的；整个过程，将next节点和random节点的拷贝操作相互独立。用hashmap<Node,Node>维护原节点和copy节点的关系；$O(n),O()$
- 参考解2：巧妙的解法$O(n),O(1)$
  - 参考解1需要使用哈希表记录每一个节点对应新节点的创建情况，可以使用一个小技巧来省去哈希表的空间

<img src="mdPics/image-20211027110650068.png" alt="image-20211027110650068" style="zoom:50%;" />

````java
package SwordOf.list;

import SwordOf.domain.Node;
import org.junit.Test;

import java.util.HashMap;

/*public class Node {
    int val;
    SwordOf.domain.Node next;
    SwordOf.domain.Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}*/

public class RopyRandomList {
    public Node copyRandomList(Node head) {

        Node scan1 = head;
        Node copyDumpHead = new Node(-1);
        Node scan2 = copyDumpHead;
        HashMap<Node, Integer> nodeMap1 = new HashMap<>();
        HashMap<Integer, Node> nodeMap2 = new HashMap<>();
        int id = 0;
        nodeMap1.put(null,id);//<null,0>的情况
        nodeMap2.put(id,null);
        while (scan1 != null) {
            id++;
            nodeMap1.put(scan1,id);
            Node newNode = new Node(scan1.val);
            scan1 = scan1.next;
            scan2.next = newNode;
            scan2 = scan2.next;
            nodeMap2.put(id,scan2);
        }
        scan1 = head;
        scan2 = copyDumpHead.next;
        while(scan1!=null){
            Node randomNodeInList1 = scan1.random;
            int randomId = nodeMap1.get(randomNodeInList1);
            Node randomNodeInCopyList = nodeMap2.get(randomId);
            scan2.random = randomNodeInCopyList;
            scan1 = scan1.next;
            scan2 = scan2.next;
        }
        return copyDumpHead.next;
    }


    /*[[7,null],[13,0],[11,4],[10,2],[1,0]]*/
    @Test
    public void test(){
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        /*---*/
        node1.next = node2;node1.random = null;
        node2.next = node3;node2.random = node1;
        node3.next = node4;node3.random = node5;
        node4.next = node5;node4.random = node3;
        node5.next = null;node5.random = node1;

        Node copy = copyRandomList(node1);
        System.out.println("--");

    }
}

class Solution {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/fu-za-lian-biao-de-fu-zhi-by-leetcode-so-9ik5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/fu-za-lian-biao-de-fu-zhi-by-leetcode-so-9ik5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
````

### [剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

如果有结点的指针，如何实现$O(1)$的删除？



### [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

- easy done



### *[剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

````java
package SwordOf.list;

import SwordOf.domain.ListNode;

public class MergeTwoLists {
    /*两条链；当前的比你小，且下一个比你大，才修改*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return  l2;
        if(l2 == null) return  l1;

        ListNode newHead;
        if(l1.val <=  l2.val){
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next,l2);
        }else{
            newHead = l2;
            newHead.next = mergeTwoLists(l1,l2.next);
        }
        return newHead;

    }
    /*非递归代码*/
   /* class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dum = new ListNode(0), cur = dum;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 != null ? l1 : l2;
            return dum.next;
        }
    }
*/

}

````



### [剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

- done



## 字符串

### [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

````text
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

````

**思路**

- 有很多方式
- 题解有一种是：创建一个3倍长的字符数组来逐个复制。

`````java
package SwordOf.String;

import org.junit.Test;

/*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。*/
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb =  new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch ==' '){
                sb.append("%20");
            }else sb.append(ch);
        }
        return  sb.toString();
    }

    @Test
    public void test(){
        String str = "we are happy.";
        String s = replaceSpace(str);
        System.out.println(s);
    }
}

`````

### [剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

````text
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 

示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"

````

````java
package SwordOf.String;

/**第 n-1个 应该在 s.length-n的位置处*/
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] arr = new char[len];
        for(int i =0;i<len;i++){
            if(i<n){
                arr[i+(len-n)] = s.charAt(i);
            }else{
                arr[i-n]=s.charAt(i);
            }
        }
        return new String(arr);
    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
````

## 查找算法

### *[剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

````text
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 

````

**思路**

- 我的就是用set ， 空间复杂度是O（1）
- 用循环移位，可以实现O(1)的空间复杂度，需要修改原来数组。一次循环移位流程结束后，会将若干个数归位到正确位置上，后续再访问到该位置时，直接跳过，因此每个位置访问次数最多两次，故时间复杂度$O(n)$

````java
package SwordOf.Array;

import java.util.HashSet;

public class FindRepeatNumber {
    /*循环移位做法*/
    public int findRepeatNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            else if (nums[nums[i]] == nums[i]) {
                ans = nums[i];
                break;
            } else {
                /*如果目的躺着的不是正确的函数，就一直发送给它;做法是和当前i位置的数交换
                * 终止挑战是 nums[i] = i ; nums[nums[i]] = nums[i]
                * for循环进入下一步*/
                while (nums[nums[i]] != nums[i]) {
                    int changeEle = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = changeEle;
                }
            }

        }
        return ans;
    }

    /*[2, 3, 1, 0, 2, 5, 3]*/
    /*Out：0 , Correct :2*/
    /*set做法*/
    /*public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int e:nums){
            if(set.contains(e)){
                return e;
            }else set.add(e);
        }
    return 0;
    }*/
}

````

### [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

- 普通二分，找到返回，再向两边探增
- 最左或者最右二分，找到一边，再想另一个方向线性探增
- 上面两个思路最坏情况时间复杂度都是 O（n）
- 同时使用最左最右二分，O（1）得出个数， O(logN)
- 最左二分和最右二分的相同点
  - 一样的思想，找到target时，不急着返回
  - 出循环时，都是left = right
- 最左二分和最右二分的不同点
  - while中对于Mid的求解，最右二分要+1;(往右嘛)

所有方法的代码

````java
package SwordOf.Array;

import org.junit.Test;

public class SearchSortCount {
    /*统计一个数字在排序数组中出现的次数。*/

    /*3-方法2在最坏情况还是可能是O（n）
     * 最优解就是 用一次最左二分+一次最右二分*/
    public int search(int[] nums, int target) {
        int leftBound = leftMaxBinarySearch(nums,target);
        int rightBound = rightMaxBinarySearch(nums,target);
        if(leftBound == -1 || rightBound == -1) return 0;
        return rightBound-leftBound+1;
    }

    public int rightMaxBinarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = -1;
        while (left < right) {
            mid = (left + right) / 2 + 1;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //不管while有没有进去，这里都符合
        mid = (left + right) / 2;//实际上，nums[left] = nums[right],因为出循环 left =right
        return nums[mid] == target ? mid : -1;

    }

    /*返回index*/
    public int leftMaxBinarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //不管while有没有进去，这里都符合
        mid = (left + right) / 2;//实际上，nums[left] = nums[right],因为出循环 left =right
        return nums[mid] == target ? mid : -1;//在接收端通过mid是不是-1来判断是否有没有target元素

    }

    /*2-最左二分,修改条件，不要一找到就返回*//*

    public int search(int[] nums, int target) {
        if(nums.length ==0) return 0;

        int left = 0,right = nums.length-1;
        int mid = 0 ;
        while(left<right){
            mid = (left+right)/2;//寻找最左目标，向下取整；寻找最右目标，要向上取整；
            if(target == nums[mid]){
                right = mid;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        */
    /*经过while有哪些情况呢？
     * 有target，找到最左元素
     * 有target,但没进入过while，数组只有1个元素时
     * 无target,但没进入过while*//*

        //以上2种可以统一得到mid下班
        mid = (left+right)/2;
        int cou=0;
        while(mid+cou<nums.length &&nums[mid+cou] == target){
            cou++;
        }
        return  cou;

    }
*/

    /*1-基本二分*/
   /* public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(index == -1) return  0 ;//找不到

        int total = 1;
        int stepLen = 1;
        while (index - stepLen >= 0 || index + stepLen < nums.length) {
            if (index + stepLen < nums.length && nums[index + stepLen] == nums[index])
                total++;
            if (index - stepLen >= 0  && nums[index - stepLen] == nums[index])
                total++;

            stepLen++;
        }
        return total;
    }*/

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 3, 3, 4, 5};
        int res1 = leftMaxBinarySearch(arr, 3);
        System.out.println(res1);
        int res2 = rightMaxBinarySearch(arr, 3);
        System.out.println(res2);
    }
}

````



### *[剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

````text
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 

示例 1:

输入: [0,1,3]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

思路

- 我也想到了二分，也想到了通过元素下标与值的关系，不断二分缩小查找区间，但是代码没有一个大佬写的整洁
- 

<img src="mdPics/image-20211030094451562.png" alt="image-20211030094451562" style="zoom:80%;" />

````java
package SwordOf.Search.Array;

public class MissingNumber {
    /*依题意，数组长度至少是1*/
    public int missingNumber(int[] nums) {
        if(nums.length == 1) return nums[0]==0 ? 1 :0;
        int left = 0,right = nums.length-1,mid = 0;
        while(left<=right){
             mid = (left+right)/2;

            if(mid == right && left == nums.length-1){//来到数组最右边，前面都符合 nums[mid] = mid
                return nums[mid]+1;
            }else if(mid == left && right == 0){//来到数组最左边，前面都符合 nums[mid] = mid+1
                return 0;
            }else if(nums[mid]==mid && nums[mid+1]==mid+2){
                break;
            }else if(nums[mid] ==mid && nums[mid+1] == mid+1){
                left = mid+1;
            }
            else{//(nums[mid] == mid+1 && nums[mid+1]==mid+2)
                right = mid;//right = mid 不是 mid+1
            }
        }
         return nums[mid]+1;

    }
}
/*------------------------------------------------------------*/
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
````



### [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

**思路**

- 由于做过，说说一些新的感触
- 这种二维数组搜索利用了二叉排序树的思想，仅仅是思想。为什么这么说呢？二叉排序树左边都是小于当前元素，右边都是大于当前元素。
- 对于二维数组，通过比较每次可以确定一个分叉是不符合的（比如$$matrix[i][j]<target$, 同行右边都不符合）。另外的部分，其实是不确定都是小的。但移动到 $matrix[i-1][j] $时，通过和taget的比较，又可以这样排除掉一行或者一列。



### [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

````text
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

**思路**

**leetcode的解**

- 更好！下次用leetcode的思路code

**剑指的解**

- 对于排序数组，我们会使用二分查找
- 本题是变形题，也能使用二分查找。**整个数组，是由两个排序子数组组成。而我们要查找的元素，是第二个排序子数组的第一个元素。每次二分判断，可以知道要找的元素，在哪一个半边。**每一次缩小查找范围后，新的范围依旧是由两个有序子数组组成！
- 代码实现要考虑一些特例
  - 旋转0元素，那么整个数组就是一个有序数组
  - 上面讲了，这里二分的思想，是每次判断目标元素在哪一个半边。当遇到[0，1，1，1，1，1]这种数组时，会出现 num[left]= num[right]=num[mid]的情况([1，0，1，1，1] 或者[1，1，1，0，1])。我们无法知道要找的元素在哪一个半边，也因此无法使用二分了。此时就用线性探测。
  - 很细节，上面这种特殊特殊情况的判断，要放在正常二分判断的前面；不然，不就人为的先缩小搜索区间了吗？而我们说了，上面的情况不能确定怎么缩小，所以会得到错误答案。
  - 另外一个小细节，在线性探测时，代码的实现要考虑到数组长度为1的情况。

````java
package SwordOf.Search.Array;

public class minRotateArray {
    public int minArray(int[] numbers) {
        int left = 0,right = numbers.length-1;
        int mid = left;//初始化为left,可以适应特例：当旋转0个元素，即旋转后数组整个有序时的情况；不会进入while循环

        while(numbers[left]>=numbers[right]){

            //这部分放最后面或者最前面都可以。但似乎放最前面，逻辑更清晰
            if(right == left+1){
                mid = right;
                break;
            }

            mid = (left+right)/2;//加一是不对的

            if(numbers[mid] == numbers[left] && numbers[mid]==numbers[right]){//第二个特例，无法确定目标元素是在第一个排序子数组，还是第二个排序子数组中，只能用线性探测了；e.g.原数组[0,1,1,1,1,1]
                /*这么写考虑不到只有一个元素的情况；因为不会进入循环*/
                /*for(int i = left;i<right;i++){
                    if(numbers[i]>numbers[i+1]) return numbers[i+1];
                }*/
                /*这么写*/
                int result = numbers[left];
                for(int i = left;i<right;i++){
                    if(numbers[i]<result) {
                        result = numbers[i];
                        break;
                    }
                }
                return result;
            }
            //这部分必须放在  numbers[mid] == numbers[left] && numbers[mid]==numbers[right] 的情况后面
            if(numbers[mid]>=numbers[left]){//要带=号，数组元素可重复
                //目标元素在第二个有序子数组
                left = mid;
            }else if(numbers[mid]<=numbers[right]){
                //目标元素在第一个有序子数组
                right = mid;
            }


        }

        return numbers[mid];

    }
}

````

### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

- easy done



### *[剑指 Offer 57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

对撞双指针

````text
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

- 双指针，肯定是''同时''移动''才叫

````java
package SwordOf.Search.Array;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;

        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
                //                return res;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = new int[]{2,7,11,15};
        int[] res =twoSum(arr,9);
        System.out.println(Arrays.toString(res));
    }
}

````



### [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

- done.

### 查找-回溯

### [剑指 Offer 12. 矩阵中的路径](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)

- 搜索回溯

````text
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

````

````java
package SwordOf.Search.Recurse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Exist {
    boolean res = false;

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                exist(board, visited, i, j, word, 0);
                if(res == true) break;
            }
            if(res == true) break;
        }

        return res;
    }

    public void exist(char[][] board, boolean[][] visited, int row, int col, String word, int index) {

        char ch = board[row][col];

        if (ch == word.charAt(index)) {
            visited[row][col] = true;
            index++;
            if(index == word.length()){
                res = true;
                return;
            }

            //从这一步递归
            if (row > 0 && visited[row - 1][col] == false && res == false)
                exist(board, visited, row - 1, col, word, index );
            if (row < visited.length - 1 && visited[row + 1][col] == false && res == false)
                exist(board, visited, row + 1, col, word, index);
            if (col > 0 && visited[row][col - 1] == false && res == false)
                exist(board, visited, row, col - 1, word, index);
            if (col < visited[0].length - 1 && visited[row][col + 1] == false && res == false)
                exist(board, visited, row, col + 1, word, index);

            index--;
            visited[row][col] = false;

        }

    }


    @Test
    public void test() {
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        String str = "abcd";
        boolean res = exist(board, str);
    }

}


````



### [剑指 Offer 13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

- done

````java
package SwordOf.Search.Recurse;

public class MovingCount {

    public int movingCount(int m, int n, int k) {
        int finalCou = 0;
        boolean[][] visited = new boolean[m][n];
        boolean[][] canReach = new boolean[m][n];
        search(m,n,k,0,0,visited,canReach);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canReach[i][j]==true) finalCou++;
            }
        }
        return finalCou;
    }
    public void search(int m ,int n , int k ,int row,int col,  boolean[][] visited,boolean[][] canReach){
        if(canReach[row][col]==false && checkReach(row,col,k)){
            visited[row][col] = true;
            canReach[row][col] = true;

            if(row>0 && visited[row-1][col]==false ) search(m,n,k,row-1,col,visited,canReach);
            if(row<m-1 && visited[row+1][col]==false ) search(m,n,k,row+1,col,visited,canReach);
            if(col>0 && visited[row][col-1]==false ) search(m,n,k,row,col-1,visited,canReach);
            if(col<n-1 && visited[row][col+1]==false ) search(m,n,k,row,col+1,visited,canReach);

            visited[row][col] = false;
        }

    }
    public boolean checkReach(int row,int col,int k){
        int x=0;
        while(row!=0 || col!=0){
            x+=row%10;
            x+=col%10;
            row/=10;
            col/=10;
        }
        if(x<=k) return true;
        else return false;

    }
}

````



### 二叉树

### [剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

- 优化：用一个栈替代oneList ， 可省去 index

````java
package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*到叶子的时候判断当前和就Ok了*/
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> resList = new ArrayList<>();

        pathSumSearch(root, target, new ArrayList<Integer>(), resList, 0,0);
        return resList;


    }

    public void pathSumSearch(TreeNode root, int target, List<Integer> oneRes, List<List<Integer>> resList, int pathSum,int index) {
        if (root == null) return;

        pathSum += root.val;
        oneRes.add(root.val);
        //是叶子，且是目标解
        if (root.left == null && root.right == null) {
            if (pathSum == target) {
                resList.add(new ArrayList<>(oneRes));
            }
        }
        if(root.left!=null){
            pathSumSearch(root.left,target,oneRes,resList,pathSum,index+1);
        }
        if(root.right!=null){
            pathSumSearch(root.right,target,oneRes,resList,pathSum,index+1);
        }
        pathSum-=root.val;
        oneRes.remove(index);

    }
}

````



### **[剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

- 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

**思路**‘

- 使用全局变量比较好做

- 不使用全局变量（make it）-小结（解题思路在代码注释中）

  - 思路清晰
  - 代码执行的结构
  - 变量引用是否被修改
  - 递归的终止条件

  ````java
  package SwordOf.Search.Tree;
  
  
  import org.junit.Test;
  
  /*return 的是head
   * 每次处理分root（root即current结点）的左边，root的右边；每一种情况又分两种情况，即空和不空，所以递归代码中，有4种情况需要考虑
   * 4种情况，处理的逻辑都是一致的，不同的情况具体操作不同而已；细节容易出错。。
   * root的左边：
   *  1-不空时：将root加到左边链表的尾部；修改相应的前驱和后继关系(左链的tail和root,root和左链的head)
   *  2-空时： 将root设置为pHead,修改相应的前驱和后继关系；
   * root的右边：
   *  1-不空时:获得右链的头尾；修改相应的前驱和后继关系(右链的head和root,右链的tail和左链的head)
   *  2-空时:do nothing. 我们对当前结点处理已经归并在处理root左边的情况中了
   * */
  public class TreeToDoublyList {
  
      public Node treeToDoublyList(Node root) {
          if(root == null) return null;
  
          Node pHead;
          Node rootOriginRight = root.right;//因为处理左链时会修改当前root的右指针，需要先保存其右链引用；
          //必须先处理左边
          if(root.left!=null){
              pHead = treeToDoublyList(root.left);
              pHead.left.right = root;
              root.left = pHead.left;
              root.right = pHead;
              pHead.left = root;
          }else{
              pHead = root;
              pHead.left = root ;
              pHead.right = root;
          }
  
          Node rightHead;
          Node rightTail;
          //处理右边
          if(rootOriginRight != null){ //note(*)
              rightHead = treeToDoublyList(rootOriginRight);
              rightTail = rightHead.left;
              //将右链的尾部和左链头连接
              rightTail.right = pHead;
              pHead.left = rightTail;
              //将右链的头部和左链尾部连接；注root是左链的尾部
              root.right = rightHead;
              rightHead.left = root;
          }else{
              //do nothing
          }
          return pHead;
  
      }
      @Test
      /*[4,2,5,1,3]*/
      public void test(){
          Node root = new Node(4);
          Node node1 = new Node(2);
          Node node2 = new Node(5);
          Node node3 = new Node(1);
          Node node4 = new Node(3);
          root.left = node1;
          root.right = node2;
          node1.left = node3;
          node1.right = node4;
  
          Node head = treeToDoublyList(root);
  
      }
  
  
  }
  
  ````

  ![image-20211119113407948](mdPics/image-20211119113407948.png)



## 排序



### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

注意里面wihle循环要加上 left<right的限定

本题是快排思想一种简单运用

````java
package SwordOf.Search.Array;

public class Exchange {
    public int[] exchange(int[] nums) {
        if(nums ==null) return null;
        int left  = 0;
        int right = nums.length -1;
        while(left<right){
            //寻找当前最左偶数
            while(left<right && nums[left]%2!=0) left++;
            //寻找当前最右奇数
            while(left<right && nums[right]%2!=1) right--;
            //交换当前left和right所指的数
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;

    }

}

````

### *[剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

- done, but not the best way
- “统一的比较规则”
- 快速排序

### *[剑指 Offer 61. 扑克牌中的顺子](https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

- 成为顺子的充分条件是什么?
  - 无重复
  - maxCard-minCard<5

## 树

### [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

- easy done

### [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

- 要求按分层

**思路**

- 我的做法是插入一个标记结点.需要注意标记结点出栈判断栈空跳出循环的情况，避免死循环
- 另外一种做法是for循环从高到低输出一层的节点数，也很巧妙

````java
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> oneRowList = new ArrayList<>();

        if (root == null) return resList;

        Queue<TreeNode> que = new LinkedList();

        que.offer(root);
        que.offer(new TreeNode(Integer.MIN_VALUE));
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.val == Integer.MIN_VALUE) {
                resList.add(new ArrayList<>(oneRowList));
                oneRowList.clear();

                if(que.isEmpty()) break; //避免死循环
                else que.offer(new TreeNode(Integer.MIN_VALUE));
            } else {
                oneRowList.add(cur.val);
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
        }

        return resList;
    }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/mian-shi-ti-32-ii-cong-shang-dao-xia-da-yin-er-c-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    
````



### [剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

**思路**

- 我的是用一个标志变量，不断变化插入顺序
- 标志变量起判奇偶层的作用。判断奇偶层还有很多方法，比如$resList.size()%2==0?$
- LinkedList 有addFirst 和 addLast 方法。当然用add(index,ele)也可以

````java
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> oneRowList = new ArrayList<>();

        if (root == null) return resList;

        Queue<TreeNode> que = new LinkedList();
        que.offer(root);

        boolean leftOrRight = true;//左到右
        while (!que.isEmpty()) {
            for(int i=que.size();i>0;i--){
                TreeNode cur = que.poll();
                if(leftOrRight)  oneRowList.add(cur.val);
                else oneRowList.add(0,cur.val);

                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
            leftOrRight = !leftOrRight;
            resList.add(new ArrayList(oneRowList));
            oneRowList.clear();
        }

        return resList;
    }
````

### [剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

````text
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：A = [1,2,3], B = [3,1]
输出：false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

**思路**

- 遍历树判断就可以了
  - 当前结点值不等，往下判断
  - 当前节点值相等，定义一个相等判断函数
- 注意空指针的情况，避免异常
- 关于书中提示的，关于浮点值的判断，无法用==，因为double 和 float 都是有精度缺失。了解一下

````java
package SwordOf.Tree.order;

import Hot100.Medium.TreeNode;
import org.junit.Test;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null) return false;

        boolean result = false;
        if(A.val == B.val){
            result = isSameStructure(A,B);
        }

        return result||isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }
    public boolean isSameStructure(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        if(A.val!=B.val) return false;

       return isSameStructure(A.left,B.left) && isSameStructure(A.right,B.right);

    }
    @Test
    public void test(){
        TreeNode A1 = new TreeNode(4);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        TreeNode A6 = new TreeNode(6);
        TreeNode A7 = new TreeNode(7);
        TreeNode A8 = new TreeNode(8);
        TreeNode A9 = new TreeNode(9);
        A1.left = A2;
        A1.right = A3;
        A2.left= A4;
        A2.right = A5;
        A3.left = A6;
        A3.right = A7;
        A4.left = A8;
        A4.right = A9;

        TreeNode B1 = new TreeNode(4);
        TreeNode B2 = new TreeNode(8);
        TreeNode B3 = new TreeNode(9);
        B1.left = B2;
        B1.right = B3;

        System.out.println(isSubStructure(A1,B1));

    }
}
````

### [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

**思路**

- 递归的思想

````java
public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode mirrorRoot = new TreeNode(root.val);

        if (root.left != null) mirrorRoot.right = mirrorTree(root.left);
        if (root.right != null) mirrorRoot.left = mirrorTree(root.right);

        return mirrorRoot;


    }
````



## 动态规划

### [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

**思路**

- 递归$O(n)$记得保存搜索结果，否则会超时
- 矩阵快速幂乘

下面讲讲什么是矩阵幂乘，其实就是pow函数。**矩阵幂乘和两个数的幂乘算法 本质是一模一样的！** 将k次缩减为$O(logk)$次；

<img src="mdPics/image-20211105103853721.png" alt="image-20211105103853721" style="zoom:50%;" />

- 在知道了快速乘法之后，想要用其解决这道题，还有1个难点，就是知道其递推公式
- <img src="mdPics/image-20211105104023250.png" alt="image-20211105104023250" style="zoom:50%;" />
- 推导这个递推公式的思想：https://www.cnblogs.com/SYCstudio/p/7211050.html

````java
package SwordOf.dynamicPro;

import org.junit.Test;

import java.util.Arrays;

public class FibFast {
    int MOD = 1000000007;

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[][] start = new int[][]{{1}, {0}};
        int[][] matrix = new int[][]{{1, 1}, {1, 0}};
        matrix = powMatrix(matrix, n - 1);
        int[][] res = matrixMultiply(matrix, start);

        return res[0][0];
    }

    //矩阵的幂乘
    public int[][] powMatrix(int[][] A, int k) {

        int[][] eachMultiply = A;
        int[][] res = new int[A.length][A.length];
        for (int i = 0; i < res.length; i++) res[i][i] = 1;

        while (k > 0) {
            if ((k & 1) == 1) {
                res = matrixMultiply(res, eachMultiply);
            }
            eachMultiply = matrixMultiply(eachMultiply, eachMultiply);
            k = k >> 1;
        }
        return res;
    }


    //两个矩阵相乘
    /*A(m*n) , B(n*t)*/
    public int[][] matrixMultiply(int[][] A, int[][] B) {
        if (A.length == 0 || A == null || B.length == 0 || B.length == 0) return null;
        if (A[0].length != B.length) return null;
        int m = A.length;
        int n = A[0].length;
        int t = B[0].length;
        int[][] res = new int[m][t];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < t; j++) {
                int oneEle = 0;
                for (int k = 0; k < n; k++) {
                    oneEle += 1l*A[i][k] * B[k][j] % MOD;
                }
                res[i][j] = oneEle;
            }
        }
        return res;
    }

    //两个数的快速幂乘算法
    public long myPower(int x, long k) {
        int check = 1;
        int eachMultiply = x;
        int res = 1;
        while (k > 0) {
            if ((k & check) == 1) {
                res *= eachMultiply;
            }
            eachMultiply *= eachMultiply;
            k = k >> 1;
        }
        return res;
    }


    @Test
    public void test2(){
        int res = fib(2);
        System.out.println(res);
    }

    @Test
    public void test() {
        int mod1 = (int) 1e9;
        double mod2 = 1e9;
        System.out.println(mod1);
        System.out.println(mod2);
    }
}

````

### [剑指 Offer 63. 股票的最大利润](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/)

````text
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 
````

**思路及代码**

````java
package SwordOf.dynamicPro;


/*动态规划：
* max[i]：表示前[i]能得到的最大利润
* minValue：表示前面股票出现的最低价格
* 动态转移方程： max[i] = 今天价格-前面的最低价格 是否大于 前i-1可以求得的最大利润？ */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length ==0 || prices == null) return 0;

        int[] max = new int[prices.length];
        max[0]=0;
        int minValue= prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]<minValue) minValue = prices[i];

            max[i] = prices[i] - minValue > max[i-1] ? prices[i] - minValue : max[i-1];
        }
        return max[prices.length-1];
    }
}

````

### [剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

- easy done

### [剑指 Offer 47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

- easy done ，用滚动数组优化

- ````java
  package SwordOf.dynamicPro;
  
  public class maxGifValue {
      /*用滚动数组优化框架复杂度*/
      public int maxValue(int[][] grid) {
          if(grid.length==0) return 0;
  
          int[] upMax = new int[grid[0].length];
          upMax[0] = grid[0][0];
          for(int i=1;i<upMax.length;i++){
              upMax[i] = upMax[i-1]+grid[0][i];
          }
  
          for(int j=1;j<grid.length;j++){
             upMax[0] = grid[j][0]+upMax[0];
              for(int i=1;i<upMax.length;i++){
                  upMax[i] =  Math.max(upMax[i-1],upMax[i])+grid[j][i];
              }
          }
          return upMax[upMax.length-1];
  
      }
  }
  
  ````

###  *[剑指 Offer 46. 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

````text
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

**思路**

- 有些动态规划题，可能一开始不一定会觉得就是用动态规划的解法，而是想着用递归，回溯。确定用动态规划的技巧是，看用递归求解时，是否有很多重复的子问题。另外，满足最优子结构；
- 本题可以从左到右动态规划，也可以从右往左
  - $f(i)= f(i-1)+f(i-2)*isMeet(g(i,i-1))$//左往右
  - $f(i)=f(i+1)+f(i+2)*isMeet(g(i,i+1))$//右往左
  - isMeet() 返回${0,1}$，注意 0+* 的情况，虽然小于25但是不能看作符合两位数的情况
- String.valueof():..

````java
public int translateNum(int num) {
        /*返回 int参数的字符串 int形式。 */
        String str = String.valueOf(num);
        int res[] = new int[str.length()];
        res[0] = 1;

        for (int i = 1; i < str.length(); i++) {

            res[i] = res[i - 1] + (i == 1 ? isMeet(str, i) : res[i - 2] * isMeet(str, i));

        }
        return res[str.length() - 1];

    }

    public int isMeet(String str, int curIndex) {
        char sec = str.charAt(curIndex);
        char fir = str.charAt(curIndex - 1);
        //符合条件的范围是 >=10 <=25
        if((fir - '0')==0 ||(fir - '0')>=3 ) return 0;
        else if (((sec - '0') + (fir - '0') * 10) <= 25) return 1;
        else return 0;
    }

````



### *[剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

````text
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

注：此题字符串中的字符没有说就是小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
````

**思路**

- 用动态规划是最快的，结合滑动窗口，达到$O(n),O(1)$,基本思路就是
- $f(i)：$表示以第i个字符结尾的最长无重复字符的子串长度
- 在确定状态转移方程时，有一个关键的变量，**d: 当前字符与上一次该字符出现的距离** 
  - if 未出现过， $f(i)=f(i-1)+1$
  - $d<=f(i-1):f(i)=d$
  - $d>f(i-1):f(i)=f(i-1)+1$

````java
package SwordOf.dynamicPro;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    /*剑指上s的值只是小写字母，但leetcode则没有这一限制；
    所以不能用一个小数组来记录下标了，需要用HashMap<字符，上一次出现的值>*/
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

      /*  int[] preAppearPosition = new int[26];
        for (int i = 0; i < 26; i++) {
            preAppearPosition[i] = -1;
        }*/
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        int len = 0;//len表示当前字符到到上一次该字符出现的情况；len>=1, 1就是相邻aa的情况;
        int fPre = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //该字符从未出现过

            if (!map.containsKey(ch)) {
//                fPre = fPre++;
                fPre++;
                map.put(ch, i);

            } else { //该字符出现过
                //先求两个该字符间的距离，再分两种情况处理
                len = i - map.get(ch);
                map.put(ch,i);

                if (len <= fPre) fPre = len;
                else {
                    //fPre = fPre++;什么玩意
                    fPre++;
                }
            }

            if (fPre > maxLen) maxLen = fPre;
        }
        return maxLen;
    }

    @Test
    public void test() {
        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);

    }

    @Test
    public void test2() {
        int i = 0;
        for (int j = 0; j < 2; j++) {
            i=++i;
//            i=i++;
        }
        System.out.println(i);
    }
}

````





