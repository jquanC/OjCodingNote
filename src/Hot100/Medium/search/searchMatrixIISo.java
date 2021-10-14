package Hot100.Medium.search;

public class searchMatrixIISo {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int i=m-1,j=0;
        while (i>=0&&j<n) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) { //二分查找往右
                j+=1;
            }else i-=1; //二分查找往上
        }
        return false;

    }
}
