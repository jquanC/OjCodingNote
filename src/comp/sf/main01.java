package comp.sf;

import java.util.Arrays;

public class main01 {
    public int resMin=0;
    public int minRemainingSpace(int[] N, int V) {
        resMin = V;
        Arrays.sort(N);
        dfs(0,N,V);
        return resMin;
    }
    public void dfs(int step,int[] N ,int res){
        if(step>=N.length || res < N[step]){ //截，做了排序
            return;
        }
        //装
        res -= N[step];
        if(res < resMin) resMin = res;
        dfs(step+1,N,res);
        res += N[step];
        //不装
        dfs(step+1,N,res);
    }

}
