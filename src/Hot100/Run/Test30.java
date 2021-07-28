package Hot100.Run;

import Hot100.Medium.So30MatrixSetZero;

import java.util.Arrays;

public class Test30 {
    public static void main(String args[]){
        So30MatrixSetZero so = new So30MatrixSetZero();
        int [][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        so.setZeros(matrix);
        for (int[] e: matrix
             ) {
            System.out.println(Arrays.toString(e));
        }
    }
}
