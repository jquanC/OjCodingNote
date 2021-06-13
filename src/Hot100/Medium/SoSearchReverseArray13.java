package Hot100.Medium;

public class SoSearchReverseArray13 {
    public int search(int[] nums,int target){
        int r = nums.length-1;
        int l = 0;

        if(r == -1) return -1;
        if(r ==0 ){
            return nums[r] == target ? 0:  -1;
        }

        while(l<=r){ //必须是l<=r , 如果存在target ，二分到最后就是 l=r 的情况
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            if(nums[l]<=nums[mid]){ // 确定[l,mid) 有序
                if(nums[l]<=target && target <nums[mid] ){
                    r = mid -1 ;
                }else{
                    l = mid + 1;
                }

            }else{ //确定(mid,r) 有序
                if(nums[r]>=target && target>nums[mid]){
                    l = mid +1;
                }else{
                    r = mid -1;
                }
            }
        }
        return -1;

    }
}
