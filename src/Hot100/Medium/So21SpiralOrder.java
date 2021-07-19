package Hot100.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class So21SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix){
        if( matrix.length == 0 || matrix[0].length==0 || Objects.isNull(matrix) ) return null;
        int totalElem = matrix.length * matrix[0].length;
        int iMax = matrix.length;
        int jMax = matrix[0].length;
        int iMin = 0;
        int jMin = 0;
        int i=0,j=0;
        List<Integer> res = new ArrayList<>();

        while(totalElem>0){ //维持 (i , j)
            //从左往右
            while(j<jMax && totalElem>0){
                res.add(matrix[i][j]);
                totalElem--;
                j++;
            }
            j--;//回溯
            iMin++;
            i++;//改变方向
            //从上往下
            while(i<iMax && totalElem>0){
                res.add(matrix[i][j]);
                totalElem--;
                i++;
            }
            i--;//回溯
            jMax--;
            j--;//改变方向
            //从右往左
            while(j>=jMin && totalElem>0){
                res.add(matrix[i][j]);
                totalElem--;
                j--;
            }
            j++;//回溯
            iMax--;
            i--;//改变方向
            //从下往上
            while(i>=iMin && totalElem>0){
                res.add(matrix[i][j]);
                totalElem--;
                i--;
            }
            i++;//回溯
            jMin++;
            j++;//改变方向
        }
    return res;
    }
}
