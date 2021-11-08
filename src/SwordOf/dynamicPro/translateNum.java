package SwordOf.dynamicPro;

import org.junit.Test;

public class translateNum {
    public int translateNum(int num) {
        /*返回 int参数的字符串 int形式。 */
        String str = String.valueOf(num);
        int res[] = new int[str.length()];
        res[0] = 1;

        for (int i = 1; i < str.length(); i++) {

            res[i] = res[i - 1] + (i == 1 ? isMeet(str, i) : res[i - 2] * isMeet(str, i));

        }
        return res[str.length() - 1];

    }

    public int isMeet(String str, int curIndex) {
        char sec = str.charAt(curIndex);
        char fir = str.charAt(curIndex - 1);
        if((fir - '0')==0 ||(fir - '0')>=3 ) return 0;
        else if (((sec - '0') + (fir - '0') * 10) <= 25) return 1;
        else return 0;
    }

    @Test
    public void test() {
        int num = 26;
        int res = translateNum(num);
        System.out.println(res);
    }
}
