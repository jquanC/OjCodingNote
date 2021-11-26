package SwordOf.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {

    public String minNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr,new myCompare());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numsStr.length; i++) {
            sb.append(numsStr[i]);
        }

        return sb.toString();
    }

    /**
     * 自定义比较器，根据数组中整数的数字字典序大小排列
     */
    class myCompare implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String str1 = (String) o1;
            String str2 = (String) o2;
            int maxLen = Math.max(str1.length(), str2.length());
            for (int i = 0; i < maxLen; i++) {
                char ch1, ch2;
                if (i < str1.length()) {
                    ch1 = str1.charAt(i);
                } else {
                    ch1 = str1.charAt(0);
                }
                if (i < str2.length()) {
                    ch2 = str2.charAt(i);
                } else {
                    ch2 = str2.charAt(0);
                }
                if (ch1 < ch2) return -1;
                if (ch1 > ch2) return 1;

            }
            //比较的两个字符串，一个是另一个的前缀时,只有两种可能，比较得出结果
            String str3 = str1+str2;
            String str4 = str2+str1;
            return str3.compareTo(str4);
        }
    }


    @Test
    public void test() {
        int a = 21;
        String str = String.valueOf(a);
        System.out.println(str);
    }

}
