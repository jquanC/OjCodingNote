package test;

import java.util.Arrays;

public class Meituan {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,2,2};
//        String[] s ={"a"};
       /* quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));*/
        int ans = findKth(a,a.length-1,3);
        System.out.println(ans);


    }
    public static int findKth (int[] a, int n, int K) {
        // write code here
        return quickFindKth(a,0,a.length-1,K);

    }
    public static void quickSort(int[] a,int start,int end){
        if(start >= end){
             return;
        }

        int sentinel = a[start];
        int left = start;
        int right = end;
        //从小到大排 1 2 3 4 5 6
        while(left < right){
            while( left<right && a[right]>=sentinel) right--;
            a[left] = a[right];
            while(left<right && a[left] <= sentinel) left++;
            a[right] = a[left];

        }
        a[left] = sentinel;
        quickSort(a,start,left-1);
        quickSort(a,left+1,end);
    }

    public static int quickFindKth(int[] a,int start,int end,int K){
//        if(start==end) return a[start];

        int sentinel = a[start];
        int left = start;
        int right = end;
        //从小到大排 1 2 3 4 5 6
        while(left < right){
            while( left<right && a[right]>=sentinel) right--;
            a[left] = a[right];
            while(left<right && a[left] <= sentinel) left++;
            a[right] = a[left];
        }
        a[left] = sentinel;

        //left 是 sentinel 在排序后数组应该的位置 3
        // 【 0 ，1 ，2 ，3】k=2,（2）
        if(left +K  == a.length){
            return a[left];
        }else if(left + K < a.length){
//            return quickFindKth(a,start,left-1,K);
            return quickFindKth(a,left+1,end,K);
        }else{
            return quickFindKth(a,start,left-1,K);
//            return quickFindKth(a,left+1,end,K);
        }

    }
}
