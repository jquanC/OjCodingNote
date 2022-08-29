package Qiu.MicroSoft;

public class Main1_2 {
    public static void main(String[] args) {
        Main1_2 so = new Main1_2();
//        int N = 15958;
//        int N = 123456756;
//        int N = 123454675;
//        int N = 15958;
//        int N = 15958;
//        int N = 500;
//        int N = -5000;
       /* int N = 51665;
        int N = 50665;*/
//        int N = -500;
//        int N = -57665;
//        int N = -51665;
//        int N = -50665;
        int  N = 453565752;
        int ans = so.solution(N);
        System.out.println(ans);
//        System.out.println(Integer.parseInt("-0521"));
    }

    public int solution(int N) {
        // write your code in Java 8 (Java SE 8)
        String str = String.valueOf(N);
        String ansStr = "";
        boolean deleted = false;
        boolean positive = (N >= 0 ? true : false);
        int selectIndex = -1;

        for (int i = 0; i < str.length(); i++) {
            //当前已经是整个字符串最后一位
            if (i + 1 == str.length()) {
                if (str.charAt(i) == '5') {
                    selectIndex = i;
                }
                break;
            }
            //后面至少还有一位的情况
            char curCh = str.charAt(i);
            char nextCh = str.charAt(i + 1);
            if (curCh == '5') {
                if (positive) {
                    if (curCh < nextCh) {
                        ansStr = str.substring(0, i) + str.substring(i + 1);
                        deleted = true;
                        break;
                    } else {
                        selectIndex = i;
                    }
                } else {
                    if (curCh > nextCh) {
                        ansStr = str.substring(0, i) + str.substring(i + 1);
                        deleted = true;
                        break;
                    } else {
                        selectIndex = i;
                    }

                }

            }

        }

        if (!deleted) {
            if (selectIndex == str.length()) {
                ansStr = str.substring(0, str.length() - 1);
            } else ansStr = str.substring(0, selectIndex) + str.substring(selectIndex + 1);
        }
        int ans = Integer.parseInt(ansStr);
        return ans;
    }

}
