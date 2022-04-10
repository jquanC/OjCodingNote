package ACMmodel.RongYao;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 2
 * 3
 * 1 3 2
 * 3
 * 2 1 3
 * out:
 * 1 1
 * 1 1
 * */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String > ans = new LinkedList<String>();
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            sc.nextLine();
            int[] record = new int[n];
            for(int j=0;j<n;j++){
                record[j] = sc.nextInt();
            }
//            if(i!=T-1)  sc.nextLine();
            sc.nextLine();
            //调用函数求解 , 不要在函数中打印每一次的解
            ans.add( slove(record));
        }
        for(String e : ans){
            System.out.println(e);
        }
    }
    public static String slove(int[] record){
        int max = 0;
        int len = record.length;
        int life = 0;

        for(int i=1;i<len;i++){
            Arrays.sort(record,0,i);
            int curNum = record[i];
            int offset = findOffset(record,0,i-1,curNum);
            life += offset;
            if(life > max) max = life;
        }
//        System.out.println(max+" "+life);
        return String.valueOf(max+" "+life);

    }

    public static int findOffset(int[] arr,int start,int end,int target){
        int l = start;
        int r = end;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] == target){
                return -(end-mid)+(mid-start);
            }
            if(arr[mid]<target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return -(end-r)+(l-start);

    }
}
