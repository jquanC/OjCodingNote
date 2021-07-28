package Hot100.Run;

import Hot100.Medium.So24SpiralMatrixII;

public class Test24 {
    public static void main(String args[]){
        So24SpiralMatrixII so24 =   new So24SpiralMatrixII();
        int [][] res = so24.generateMatrix(4);
        for(int[] e: res){
            for(int ele: e){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
