package Hot100.Medium;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class So33Combine {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> oneAns = new ArrayList();
    int count =0;
    public List<List<Integer>> combine(int n, int k){

        File f1 = new File(this.getClass().getResource("/").getPath());
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println("path1: "+f1);
        System.out.println("path1: "+f2);

        /*File newFile = new File(f.toString()+)*/

        cutDfs(1,n,k);
        return ans;
    }
    private void cutDfs(int step,int n, int k ){

        if(count == k){
            ans.add(new ArrayList<>(oneAns));
            return;
        }else if( count+(n-step+1) < k  ) return ;

        oneAns.add(step);
        count+=1;
        cutDfs(step+1,n,k);
        oneAns.remove(oneAns.size()-1);
        count-=1;

        cutDfs(step+1,n,k);

    }
}
