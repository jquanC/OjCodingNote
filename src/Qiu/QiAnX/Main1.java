package Qiu.QiAnX;

public class Main1 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] nodex = new int[5][];
        nodex[0] = new int[]{1,2,3};
        nodex[1] = new int[]{3};
        nodex[2] = new int[]{3};
        nodex[3] = new int[]{4};
        nodex[4] = new int[0];
        int ans = so.DagPathNum(nodex);
        System.out.println(ans);

    }

}
class Solution {


    //数组下标的节点编号
    //终点节点的编号是数组长度
    //终点标志：当前节点编号==数组长度
    int ans = 0;
    public int DagPathNum (int[][] nodes) {
        // write code here
        int target = nodes.length-1;
        int[] startArr = nodes[0];
        for(int i=0;i<startArr.length;i++){
            dfs(nodes,startArr[i],target);
        }
        return ans;
    }
    public void dfs(int[][]nodes,int curIndex,int target){
        if(curIndex == target){
            ans++;
            return;
        }
        int[] curNextArr = nodes[curIndex];
        if(curNextArr.length==0) return;

        for(int i=0;i<curNextArr.length;i++){
            dfs(nodes,curNextArr[i],target);
        }
    }
}