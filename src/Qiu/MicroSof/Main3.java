package Qiu.MicroSof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Node {
    int index;
    int people = 1;
    int upbound = 5;
    int cost = 1;
    int len;
}

public class Main3 {
    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int maxLen = 1;
//        HashMap[] sets = new HashMap[A.length+1];
        ArrayList<HashMap<Integer, HashSet<Node>>> mapList = new ArrayList();

        HashMap<Integer, HashSet<Node>> oneMap = new HashMap();
        HashSet<Node> nodeSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0 || B[i] == 0) {
                int index = A[i] == 0 ? A[i] : B[i];
                Node curNode = new Node();
                curNode.index = index;
                curNode.len = 1;
                nodeSet.add(curNode);
            }
            oneMap.put(maxLen, nodeSet);
        }
        mapList.add(oneMap);
        while (initial(mapList, maxLen++)) ;

        if (A.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) set.add(A[i]);
            if (B[i] != 0) set.add(B[i]);

        }

        return set.size();
    }

    public boolean initial(ArrayList<HashMap<Integer, HashSet<Node>>> mapList, int len) {
        HashMap<Integer, HashSet<Node>> curMap = mapList.get(len - 2);
//        for(Integer e:curMap.keySet())
        return false;
    }
}
