package ACMmodel.ByteDance.re;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WordToWordTrie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        Trie trieTree = new Trie();
        for(int i=0;i<n;i++){
            int len = sc.nextInt();
            int[] signalArr = new int[len];
            for(int j=0;j<len;j++){
                signalArr[j] = sc.nextInt();
            }
            trieTree.inserSignal(signalArr);
            sc.nextLine();
        }
        int[] ans = new int[m];
        for(int j=0;j<m;j++){
            int len = sc.nextInt();
            int[] signalArr = new int[len];
            for(int t=0;t<len;t++){
                signalArr[t] = sc.nextInt();
            }
            ans[j] = trieTree.getPrefixCou(signalArr);
        }
        System.out.println(Arrays.toString(ans));

    }
}

class Trie {
    public HashMap<Integer,Trie> map = new HashMap<>();
    boolean isEnd;
    int prefixCou;

    public boolean inserSignal(int[] arr){
        Trie cur = this;
        for(int i=1;i<arr.length;i++){
            if(cur.map.containsKey(arr[i]-arr[i-1])){
                cur = cur.map.get(arr[i]-arr[i-1]);
                cur.prefixCou++;
                continue;
            }
            cur.map.put(arr[i]-arr[i-1],new Trie());
            cur = cur.map.get(arr[i]-arr[i-1]);
            cur.prefixCou++;
        }
        return true;

    }
    public int getPrefixCou(int[] arr){
        Trie  cur = this;
        for(int i=1;i<arr.length;i++){
            cur  = cur.map.get(arr[i]-arr[i-1]);
        }
        return cur.prefixCou;

    }
}
