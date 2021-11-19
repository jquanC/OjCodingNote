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
