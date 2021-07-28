package Hot100.Medium;

public class So24SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];//当我们声明了一个变量，却没有将该变量指向任何创建的对象，然后就使用它的时候，NullPointerException 就发生了
        int num = 1;
        int i = 0, j = 0, iMin = 0, iMax = n, jMin = 0, jMax = n;
        while (num <= n * n) {

            while (j < jMax && num <= n * n) {
                res[i][j] = num;
                //当我们声明了一个变量，却没有将该变量指向任何创建的对象，然后就使用它的时候，NullPointerException 就发生了
                num++;
                j++;
            }
            iMin += 1;
            j -= 1;
            i += 1;
            while (i < iMax && num <= n * n) {
                res[i][j] = num;
                num++;
                i++;
            }
            jMax -= 1;
            i -= 1;
            j -= 1;
            while (j >= jMin && num <= n * n) {
                res[i][j] = num;
                num++;
                j--;
            }
            iMax -= 1;
            j += 1;
            i -= 1;
            while (i >= iMin && num <= n * n) {
                res[i][j] = num;
                num++;
                i--;
            }
            jMin += 1;
            i += 1;
            j += 1;
        }
        return res;
    }
}
