package ACMmodel.TenCent.re221013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 输入:
 [{1,2,3},{2,3,4},{4,1}]
 输出:
 {1,2,3,4}
 输入:
 [{3,7,4},{7,4,5,1,10,3}]
 输出:
 {1,5,4,7,3,10}
* */
public class Main3 {
    HashMap<Integer,Integer> preMap = new HashMap();
    HashMap<Integer,Integer> postMap = new HashMap();
    int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Main3 so = new Main3();
      /*  ArrayList<Integer> one = new ArrayList();
        ArrayList<Integer> two = new ArrayList();
        ArrayList<Integer> three = new ArrayList();
        one.add(1);one.add(2);one.add(3);
        two.add(2);two.add(3);two.add(4);
        three.add(4);three.add(1);
        ArrayList<Integer>[] listsArr = new ArrayList[3];
        listsArr[0] = one;
        listsArr[1] = two;
        listsArr[2] = three;*/
        ArrayList<Integer> one = new ArrayList();
        ArrayList<Integer> two = new ArrayList();
        ArrayList<Integer>[] listsArr = new ArrayList[2];
        one.add(3); one.add(7); one.add(4);
        two.add(7); two.add(4); two.add(5); two.add(1); two.add(10); two.add(3);
        listsArr[0] = one;
        listsArr[1] = two;
        List<Integer> ans =  so.cal(listsArr);
        System.out.println(ans.toString());

    }
    public List<Integer> cal(ArrayList<Integer>[] listArr){
        for(List<Integer> e: listArr){
            for(int i=0;i<e.size();i++){
                if(i-1>=0){
                    preMap.put(e.get(i),e.get(i-1));
                }
                if(i+1<e.size()){
                    postMap.put(e.get(i),e.get(i+1));
                }
                if(e.get(i)<minVal) minVal = e.get(i);
            }
        }
      /*  StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();*/

        int nextVal = minVal;
        int nextV1= minVal;
        int nextV2 = minVal;
        boolean flag = false; //f-think pre is min
        while(true){
//            s1.append(nextVal);
            nextV1 = preMap.get(nextV1);
            nextV2 = postMap.get(nextV2);
//            if(nextV1 == nextV2) continue;

            if(nextV1<nextV2){
                flag = false;
                break;
            }
            if(nextV1>nextV2){
                flag = true;
                break;
            }
            if(nextV1 == minVal) break;
        }
        /*while(true){
            s2.append(nextVal);
            nextVal = postMap.get(nextVal);
            if(nextVal == minVal) break;
        }*/
        List<Integer> ans = new ArrayList();
     /*   System.out.println("s1  "+s1.toString());
        System.out.println("s2  "+s2.toString());*/
        if(!flag){
            while(true){
                ans.add(nextVal);
                nextVal = preMap.get(nextVal);
                if(nextVal == minVal) break;
            }

        }else{
            while(true){
                ans.add(nextVal);
                nextVal = postMap.get(nextVal);
                if(nextVal == minVal) break;
            }

        }
        return ans;

    }
}
