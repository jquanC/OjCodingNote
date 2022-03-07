package ACMmodel.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**千言转文字*/
public class BD03WordtoWord {
    public static void main(String[] args){
        int n,m,k;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        in.nextLine();

        List<int[]> diifAList =  new ArrayList<>();
        for(int i=0;i<n;i++){
            int len = in.nextInt();
            int [] eachAArr = new int[len];
            int [] eachDiffA = new int[len-1];
            for(int j=0;j<len;j++){
                eachAArr[j] = in.nextInt();
                if(j!=0){
                    eachDiffA[j-1] = eachAArr[j]-eachAArr[j-1];
                }
            }
            diifAList.add(eachDiffA);
            in.nextLine();
        }

        List<int[]> diffBList = new ArrayList<>();
        for(int i=0;i<m;i++){
            int len = in.nextInt();
            int[] eachBArr = new int[len];
            int[] eachDiffB = new int[len-1];
            for(int j=0;j<len;j++){
                eachBArr[j] = in.nextInt();
                if(j!=0){
                    eachDiffB[j-1] = eachBArr[j]-eachBArr[j-1];
                }
            }
            diffBList.add(eachDiffB);
            in.nextLine();
        }
        Trie trieTree = new Trie();
        //对于diffAList 执行Inset
        for(int[] e : diifAList){
            trieTree.insert(e);
        }

        //对于diffBList 执行查询
        for(int[] e:diffBList){
            int res = trieTree.searchPrefix(e);
            System.out.println(res);
        }

    }
    static class Trie{
        HashMap<Integer,Trie> map;
        int countPath; //统计以该trie结点之前 diff 路径，并到此结束的数量
        int countPrefix; //统计以该trie结点)之前 diff 路径为前缀的数量

        //初始化
        public Trie(){
            map = new HashMap<Integer,Trie>();
            countPath =0;
            countPrefix =0;
        }

        public void insert(int[] diff) {
            Trie cur = this;
            for(int i=0;i<diff.length;i++){
                if(!cur.map.containsKey(diff[i])){
                    cur.map.put(diff[i],new Trie());
                }
                cur = cur.map.get(diff[i]);
                cur.countPrefix++;
            }
            cur.countPath++;

        }
        public int search(int[] diff){
            Trie cur = this;
            for(int i=0;i<diff.length;i++){
                if(cur.map.containsKey(diff[i])){
                    cur = cur.map.get(diff[i]);
                }else{
                    return -1;
                }
            }
            return cur.countPath;
        }
        /** @ return: -1 无该前缀*/
        public int searchPrefix(int[] diff){
            Trie cur = this;
            for(int i=0;i<diff.length;i++){
                if(cur.map.containsKey(diff[i])){
                    cur = cur.map.get(diff[i]);
                }else{
                    return -1;
                }
            }
            return cur.countPrefix;
        }
    }
}
