package SwordOf.dynamicPro;

public class maxGifValue {
    /*用滚动数组优化框架复杂度*/
    public int maxValue(int[][] grid) {
        if(grid.length==0) return 0;

        int[] upMax = new int[grid[0].length];
        upMax[0] = grid[0][0];
        for(int i=1;i<upMax.length;i++){
            upMax[i] = upMax[i-1]+grid[0][i];
        }

        for(int j=1;j<grid.length;j++){
           upMax[0] = grid[j][0]+upMax[0];
            for(int i=1;i<upMax.length;i++){
                upMax[i] =  Math.max(upMax[i-1],upMax[i])+grid[j][i];
            }
        }
        return upMax[upMax.length-1];

    }
}
