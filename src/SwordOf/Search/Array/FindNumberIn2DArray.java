package SwordOf.Search.Array;

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length ==0) return false;
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int i = m,j=0;
        boolean res = false;
        while(i>=0 && j<=n){
            if(matrix[i][j] == target){
                res = true;
                break;
            }
            else if(matrix[i][j]<target){
                j++;
            }else{
                i--;
            }
        }
        return res;
    }
}
