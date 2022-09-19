package Qiu.DIDI;

import java.util.Scanner;
import java.util.TreeMap;

/*
*第一行有三个正整数n,p,q(1<=n<=100000,1<=p,q<=n)，代表刷漆的次数，以及两个参数 p 和 q。

第二到四行给出了一个大小为3*n的矩阵，第 i 列的三个数从上到下记为l,r,t(1<=l,r<=1000000000,1<=t<=2)，
* 代表第i次刷漆将编号在 l 到 r 之间的栅栏刷了一遍 t号油漆。
in:
5 2 2
1 1 2 3 2
3 5 4 5 4
1 2 1 1 2

out:3
* */
class Wood{
    public int idx;
    public int pCou;
    public int qCou;
    public Wood(int idx){
        this.idx = idx;
    }
}
public class Main2Re {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pOne = sc.nextInt();
        int qTwo = sc.nextInt();
        sc.nextLine();
        //差分数组
        int[][] arr = new int[3][n];
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        TreeMap<Integer,Wood> map = new TreeMap();
        for(int i=0;i<n;i++){
            int l = arr[0][i];
            int r = arr[1][i];
            if(arr[2][i]==1){
                if(map.containsKey(l)){
                    Wood cur = map.get(l);
                    cur.pCou++;//不用再put了
                }else{
                    Wood addL = new Wood(l);
                    addL.pCou++;
                    map.put(l,addL);
                }
                if(map.containsKey(r+1)){
                    Wood cur = map.get(r+1);
                    cur.pCou--;
                }else{
                    Wood addR = new Wood(r+1);
                    addR.pCou--;
                    map.put(r+1,addR);
                }
            }else{
                if(map.containsKey(l)){
                    Wood cur = map.get(l);
                    cur.qCou++;//不用再put了
                }else{
                    Wood addL = new Wood(l);
                    addL.qCou++;
                    map.put(l,addL);
                }
                if(map.containsKey(r+1)){
                    Wood cur = map.get(r+1);
                    cur.qCou--;
                }else{
                    Wood addR = new Wood(r+1);
                    addR.qCou--;
                    map.put(r+1,addR);
                }

            }
        }
        long pNums = 0;
        long qNums = 0;
        long ans = 0;
        for(Integer e:map.keySet()){
            Wood cur = map.get(e);
            pNums += cur.pCou;
            qNums += cur.qCou;
            if(pNums>=pOne && qNums>=qTwo) ans++;
        }
        System.out.println(ans);

    }
}
