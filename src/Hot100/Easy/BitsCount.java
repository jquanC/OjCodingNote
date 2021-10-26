package Hot100.Easy;

public class BitsCount {
    /*一个二进制数中1的个数，等于 x&(x-1)至0 的次数*/
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x = x & (x - 1);
            ones++;
        }
        return ones;
    }
}
