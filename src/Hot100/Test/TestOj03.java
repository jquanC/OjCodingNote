package Hot100.Test;

import org.junit.Test;

import java.util.HashSet;

public class TestOj03 {
    //dp[i] 表示以s[i]结尾的 最长不含重复字符的 子字符串
    public int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
                set.add(s.charAt(i));
            } else {
                int j = i - dp[i - 1];
                for (; j < i; j++) {
                    char ch = s.charAt(j);
                    if (ch == s.charAt(i)) {
                        //set.remove(ch);//不用remove 和add抵消了
                        dp[i] = i - j;
                        break;
                    }
                    set.remove(ch);
                }
            }
            if (dp[i] > ans) ans = dp[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);

        String a = "123";
        String b = new String("123");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    public int testMeth() {
        int a=0;
        try {
             a = 10;
            System.out.println(a / 0);
            System.out.println("异常后面的不会执行了");
        } catch (Exception e) {
            System.out.println("除0异常");
            return a;
        } finally {
            return a+2;
        }
    }

    @Test
    public void test2() {
            int res= testMeth();
        System.out.println(res);

    }
}
