package Hot100.Medium;

/*
 * 1 从后往前寻找第一个非降序的数，记为a[i]；找不到是整个排列降序的情况
 * 2 从后往前寻找第一个比a[i]大的数,记为a[j]
 * 3.交换a[i] 和 a[j]
 * 4.并重排[j,...]之后的元素为升序，由于num[j,...] 这部分元素一定是降序，所以直接用双指针交换实现
 * */
public class SolutionNextPermutation11 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] <= nums[i - 1]) i--;
            else {
                break;
            }
        }

        if (i == 0) {
            reSort(nums,i,nums.length-1);
        } else { //原排列必定不是降序的
            int j = nums.length - 1;
            i--;
            while (j > 0) {
                if (nums[j] <= nums[i]) j--;
                else break;
            }
            swap(nums,i,j);
            reSort(nums,i+1,nums.length-1);
        }

    }
    private void swap(int nums[],int index_i,int index_j){
        int temp = nums[index_i];
        nums[index_i] = nums[index_j];
        nums[index_j] = temp;
    }
    private void reSort(int[] nums, int start , int end){
        while(end>start){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
