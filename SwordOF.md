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