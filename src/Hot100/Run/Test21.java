package Hot100.Run;

import Hot100.Medium.So21SpiralOrder;

import java.util.List;

public class Test21 {
    public static void main(String args[]) {
        int [][] matrix = new int[][]{{1,2,3,12},{4,5,6,56},{7,8,9,49}};
        So21SpiralOrder so = new So21SpiralOrder();
        List<Integer> res =  so.spiralOrder(matrix);
        System.out.println(res.toString());
    }
}
