package Hot100.Run;

import Hot100.Medium.So31BinarySearchInMatrix;

public class Test31 {
    public static void main(String args[]){
        So31BinarySearchInMatrix so = new So31BinarySearchInMatrix();
        int[][] matrix = new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60} };
         boolean res = so.searchMatrix(matrix,13);
        System.out.println(res);
    }
}
