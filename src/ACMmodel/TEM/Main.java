package ACMmodel.TEM;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }

    public int minMax(ArrayList<Integer> a, int k, int x) {
        // write code here
        PriorityQueue<Integer> que = new PriorityQueue<>((m, n) -> (n - m));
        for (int e : a) {
            que.add(e);
        }
        for (int i = 1; i <= k; i++) {
            int curMax = que.poll();
            curMax -= x;
            que.add(curMax);
        }
        return que.poll();
    }

    public int minCnt(String s) {
        // write code here
        int len = s.length();
        boolean firstBit = false;
        int opCou = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (firstBit == false) {
                if (ch == '0') {
                    opCou++;
                    continue;
                }
                if (ch == '1') {
                    firstBit = true;
                    continue;
                }
            } else {
                if (ch == '1') {
                    opCou++;
                }
            }

        }
        return opCou;
    }

    public int numsOfStrings(int n, int k) {
        // write code here
        if (n / k < 2) return 0;
        if(n/k==2){
            int tem=0;
            for(int i=1;i<=k;i++){
                if(i==1) tem+= 26;
                else tem *=25;
            }
            return tem;
        }

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
        return ans;
    }


}
