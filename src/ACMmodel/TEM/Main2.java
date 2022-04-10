package ACMmodel.TEM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main2 {
    HashMap<Integer,Integer> map;
    public static void main(String[] args) {

    }


    public int numsOfStrings(int n, int k) {

        // write code here
        if (n / k < 2) return 0;
        map = new HashMap<>();

        int ans = dfs(n, 0, n, k);
        return ans;


    }

    public int dfs(int resChNum, int segCou, int n, int k) {
        if (segCou == k) {
            if (resChNum != 0) return 0;
            else return 1;
        }
        if (resChNum <= 0) {
            if (segCou != k) return 0;
            else return 1;
        }
        if(map.containsKey(resChNum)) return map.get(resChNum);

        //该层这一段的长度范围是：
        int ans = 0;
        int lenUpBound = resChNum - 2 * (k - 1 - segCou);
        for (int len = 2; len <= lenUpBound; len++) {
            //第一段有26选择
            if (segCou == 0) {
                ans += 26 * dfs(resChNum - len, segCou + 1, n, k);
                ans %= 1000000;
            } else { //每一段都有25种选择
                ans += 25 * dfs(resChNum - len, segCou + 1, n, k);
                ans %= 1000000;
            }
        }
        map.put(resChNum,ans);
        return ans;
    }

}
