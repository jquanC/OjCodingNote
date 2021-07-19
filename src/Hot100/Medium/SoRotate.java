package Hot100.Medium;

public class SoRotate {
    public void rotate (int[][] matrix){
        int n = matrix.length;
        //方法1：
        for(int i=0; i<n/2;i++){
            int temp;
            for(int j=0 ; j<(n+1)/2;j++){

               /*分析过程
                matrix[j][n-i-1] = matrix[i][j];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[i][j] = matrix[n-j-1][i];*/

                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;

            }
        }

        //方法2：用翻转代替旋转
        //上下翻转
        for(int i=0;i<n/2;i++){
            int temp;
            for(int j=0;j<n;j++){
                temp = matrix[n-i-1][j];
                matrix[n-i-1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //对角线翻转
        for(int i=0; i<n;i++){
            int temp;
            for(int j=i+1 ; j<n ; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
