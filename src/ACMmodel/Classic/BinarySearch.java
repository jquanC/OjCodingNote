package ACMmodel.Classic;


import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public int find(int[] arr, int ele, int start, int end) {
        int left = start;
        int right = end;


        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == ele) return mid;

            if (arr[mid] < ele) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public int findRight(int[] arr, int ele, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= ele) {
                left = mid+1; // 有效缩小区间
            } else {
                right = mid; // 有效缩小区间
            }
        }
        if(arr[left] == ele) return left;
        if(left-1>0 && arr[left-1] == ele) return  left-1;
        else return -1;
    }

    public int findLeft(int[] arr, int ele, int start, int end) {
        int left = start;
        int right = end;

        while(left < right){
            int mid = (left+right)/2;
            if(arr[mid] >= ele){
                right = mid; //因为left!=right,可以有效缩小区间
            }else{
                left = mid+1;//同样，都是需要有效缩小区间
            }
        }
        if(arr[left] == ele) return  left;
//        if(arr[left+1] == ele) return left+1;//有必要吗？没有
        return -1;
    }
    @Test
    public  void test(){

        int[] arr4 = new int[]{0,1,2,4,5,7,7};//len 7
        int[] arr5 = new int[]{0,1,2,4,7,7,7};//len 7
        int[] arr6 = new int[]{0,1,2,4,6,6,7};//len 7


        System.out.println(find(arr4,7,0,6));
        System.out.println(findLeft(arr4,7,0,6));
        System.out.println(findRight(arr4,7,0,6));

        System.out.println(find(arr5,7,0,6));
        System.out.println(findLeft(arr5,7,0,6));
        System.out.println(findRight(arr5,7,0,6));

        System.out.println(find(arr6,6,0,6));
        System.out.println(findLeft(arr6,6,0,6));
        System.out.println(findRight(arr6,6,0,6));

    }
}
