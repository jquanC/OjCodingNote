package Qiu.Mi;

import SwordOf.Search.Tree.Node;

public class Main2 {
    Node listHead = null;
    Node pre = null;
    public Node  Convert(Node pRootOfTree) {
        if(pRootOfTree == null) return  null;
        recurConvert(pRootOfTree);
        return listHead;
    }
    public void recurConvert(Node curNode) {
        if(curNode == null) return ;
        recurConvert(curNode.left);
        if(pre == null){
            listHead = curNode;
        }else{
            pre.right = curNode;
            curNode.left = pre;
        }
        pre = curNode;
        recurConvert(curNode.right);
    }
}
