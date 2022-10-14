package Qiu.TME;

import java.util.ArrayList;

public class Main2_Re {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(50);
        list.add(4);
        Main2_Re so = new Main2_Re();
       int ans =  so.getSubarrayNum(list,2);
        System.out.println(ans);
    }
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        long ans = 0;
        long P = 1000000007;
        int[] cou2 = new int[a.size()+1];//是统计的前缀和
        int[] cou5 = new int[a.size()+1];//
        for(int i=1;i<=a.size();i++){
            int num = a.get(i-1);
            while(num%5==0){
                cou5[i]++;
                num/=5;
            }
            cou5[i] += cou5[i-1];
            while(num%2==0){
                cou2[i]++;
                num/=2;
            }
            cou2[i]+=cou2[i-1];
        }

        for(int i=1;i<cou2.length;i++){//枚举区间起点
            int a1 = find(cou2,x+cou2[i-1]);//x+cou2[i-1],因为需要统计的满足从[L,... 开始的因数个数，前面的需要需要舍去，相对应要寻找x+cou[L-1]个
            int a2 = find(cou5,x+cou5[i-1]); // i 还是 i+1？
            ans += cou2.length- Math.max(a1,a2);
            ans %= P;
        }
        return (int)ans;

    }
    //满足cou[idx]>x的最小(左)idx
    public int find(int[] cou,int x){
        int l = 1;
        int r = cou.length-1;

        while(l<r){ //还要分有解 没解的情况
            int mid = l+(r-l)/2;
            if(cou[mid]>=x){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        //因为不一定有解，需要判断
        if(l== cou.length-1 && cou[l]<x) return cou.length;
        else return l;
    }

}
