package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;

/**20220419 第三次做
 * 对输出结果取模*/
public class ReversePairsIII {
    @Test
    public void test(){
        int[] arr = new int[]{3,4,1,2};
        int ans = InversePairs(arr);
        System.out.println(ans);
    }
    private  int p = 1000000007;
    public int InversePairs(int[] array) {
        if (array ==null || array.length ==1 || array.length==0) return 0;
        return merge(array,0,array.length-1);
    }
    public int merge(int[]arr,int start,int end){

        if(start == end) return 0;
        int mid = (start+end)/2;
        long subCou1 = merge(arr,start,mid)%p;
        long subCou2 = merge(arr,mid+1,end)%p;
        long cou3 = 0;
        int p1 = mid;
        int p2 = end;
        int [] temp = new int[end-start+1];
        int pt = temp.length-1;
        while(p1>=start && p2>=mid+1){
            if(arr[p1]>arr[p2]){
                temp[pt] = arr[p1];
                p1--;
                pt--;
                cou3 += p2-mid;
                //即使你用了long,还是有办法让你超；从根源上 每次大于p，就mod p
                if(cou3>p){
                    cou3%=p;
                }
            }else{
                temp[pt] = arr[p2];
                p2--;
                pt--;
            }
        }
        while(p1<start && p2>=mid+1){
            temp[pt] = arr[p2];
            p2--;
            pt--;
        }
        while(p1>=start && p2<mid+1){
            temp[pt] = arr[p1];
            p1--;
            pt--;
        }
        for(int i=start;i<=end;i++){
            arr[i] = temp[i-start];
        }
        return (int)(subCou1+subCou2+cou3)%p;
    }

}
