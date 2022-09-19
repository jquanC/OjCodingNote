package Qiu.Oppo;

import java.util.Arrays;

public class Main1 {
    public int maxDigit (int[] digits) {
        // write code here
        Arrays.sort(digits);
        int ans = 0;
        for(int i=digits.length-1;i>=0;i--){
            ans = ans*10+digits[i];
        }
        return ans;
    }
}
