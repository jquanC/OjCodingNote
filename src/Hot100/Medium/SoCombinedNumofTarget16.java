package Hot100.Medium;

import Hot100.Easy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoCombinedNumofTarget16 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
            //  对candidate 做升序，方便回溯和截枝
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        soSearch(0, candidates,ans,combine,target);
        return  ans;

    }
    private void soSearch(int dix,int[]candidate , List<List<Integer>> ans, List<Integer>combine, int target){

        if(target == 0){
            ans.add(new ArrayList<Integer>(combine) );
            return;
        }
        if(dix >= candidate.length || candidate[dix] > target ){
            return ;
        }
        if(candidate[dix] <= target){
           //有两种选择，选择 和 不选择；注意由于每个数可以选无限制次，所以选择了的，dix 不增加
            // 选择candidate[dix]
            combine.add(candidate[dix]);
            soSearch(dix,candidate,ans,combine,target-candidate[dix]);


            //不选择
           // boolean f = combine.remove(Object(candidate[dix])); //先回溯
            combine.remove(new Integer(candidate[dix]));
            /*本意是传入删除元素并删除，但remove方法删除元素需要是Object类型；恰巧是int[]数组，传入int 元素变成了调用删除指定index
            位置处的元素， candidate[1]=3, 编译器理解成删除 List中Index=3的元素，所以报ArrayList 越界错误
            另外一个知识点： List 删除某一个元素后，index 会自动重排
            */
              soSearch(dix+1,candidate,ans,combine,target);

        }


    }
}
