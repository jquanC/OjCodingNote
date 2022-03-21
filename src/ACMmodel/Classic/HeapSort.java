package ACMmodel.Classic;

import java.util.Arrays;
import java.util.Scanner;

//单纯中sort的角度来说：1 接收一个数组 2.对他排序
public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        Heap mHeap = new Heap(arr);
        int[] res = mHeap.sort();
        System.out.println(Arrays.toString(res));

    }

    //小顶堆
    static class Heap {
        private int[] arr;
        private int len; //表示当前维护堆的节点数

        public Heap(int[] arr) {
            this.arr = arr;
            this.len = arr.length;
            build(arr);
        }

        /**
         * 堆化: i -l: 2i+1, -r: 2*(i+1) , i从0开始
         * i -parent:(i-1)/2
         * 递归维护 以 index 结点为根的 “小顶堆”
         */
        public void heapify(int[] arr, int index,int upBound) {

            int lc = 2 * index + 1, rc = 2 * (index + 1);

            if ((lc<upBound && arr[index] > arr[lc])||( rc<upBound && arr[index] > arr[rc] )) {
                int swapIndex = -1;
                //进来后，还要再判断lc rc 是否合法，因为可能一方合法
                if(rc >= upBound) swapIndex = lc;
                else if(lc>=upBound) swapIndex = rc;
                else{
                    //两个是合法的情况！
                    swapIndex = arr[lc]< arr[rc] ? lc:rc; //既然明确了是小顶堆，选最小的子节点上去
                }
                int tem = arr[index];
                arr[index] = arr[swapIndex];
                arr[swapIndex] = tem;
                heapify(arr,swapIndex,upBound);
            }
        }

        /**建堆*/
        public void build(int[] arr){
            /* 第一个非叶结点下标：(len-1-1)/2*/
            for(int i= (len-1-1)/2;i>=0;i--){
                heapify(arr,i,len);
            }
        }
        /**堆排序*/
        public int[] sort(){
            //swap: 0 len-1, 0 len-2 ,
            int sortBound = this.len-1;
            for(int i=sortBound;i>=0;i--){
                int tem = arr[i];
                arr[i] = arr[0];
                arr[0] = tem;
                heapify(arr,0,sortBound--);
            }
            return arr;
        }
    }
}
