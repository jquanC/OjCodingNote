package Hot100.Easy;
/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

/**
 关键点: java中整数如何转为二进制数？二进制数如何存储表达
 尝试用数组
 时间复杂度： lg(n)
 空间复杂度： lg(n)

 */
class Solution2 {
    public int hammingDistance(int x, int y) {
        int[] binaryArrX = calBinary(x);
        int[] binaryArrY = calBinary(y);
        int count =0;
        for(int i=0;i<31;i++){
            if(binaryArrX[i] != binaryArrY[i]) count++;
        }
        return count;

    }
    public int[] calBinary(int x){
        int binaryArr[] = new int [31];
        for(int i=30;i>=0;i--){
            if( x/Math.pow(2,i) >=1 ){
                x %= Math.pow(2,i);
                binaryArr[i]=1;
            }
        }
        return binaryArr;
    }
}

