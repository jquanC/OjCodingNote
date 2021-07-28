package Hot100.Medium;

public class So32ColorCluster {
    public void sortColors(int[] nums){

        /*// 解法一
        int a=0,b=0,c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) a++;
            else if(nums[i]==1) b++;
            else c++;
        }

        for(int i=0;i<nums.length;i++){
            if(a>0){
                nums[i] = 0;
                a--;
            }else if(b>0){
                nums[i] =1 ;
                b--;
            }else
                nums[i] =2 ;
        }*/

        //解法2：单指针遍历2次
        //解法3：双指针遍历1次
        int p0=0, p1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0<p1){
                    int temp2 = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp2;
                }
                p0++;
                p1++; //因为0是最前面，p1>=p0的
            }else if(nums[i]==1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }

        }
    }
}
