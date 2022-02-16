package test.MS;

import org.junit.Test;

public class Solution3 {

    public int solution(int N) {
        N++;
        String nstr = String.valueOf(N);
        char[] carr = nstr.toCharArray();

        while (!isMeeted(carr)) {
            adjust(carr);
        }
        String s = String.valueOf(carr);
        int ans = Integer.valueOf(s);

        return ans;
    }

    public void adjust(char[] carr) {
        //寻找第一个两个连续的字符，从高位开始调整；
        for (int i = 0; i < carr.length - 1; i++) {
            if (carr[i] == carr[i + 1]) {
                if (carr[i] == '9') {//注意是最高的情况
                    //先置0
                    for(int j = i;j<carr.length;j++){
                        carr[j]='0';
                    }
                    if(i==0){//是高位
                        char[] newArr = new char[carr.length+1];
                        newArr[0]='1';
                        for(int j=1;j<newArr.length;j++){
                            newArr[j] = carr[j-1];
                        }

                    }else{
                        carr[i-1]+=1;
                    }
                    break;

                }else {
                    carr[i + 1] += 1;
                    for(int j=i+2;j<carr.length;j++) carr[j]='0';
                    break;
                }
            }
        }

    }

    public boolean isMeeted(char[] carr) {
        for (int i = 0; i < carr.length - 1; i++) {
            if (carr[i] != carr[i + 1]) continue;
            else return false;
        }
        return true;
    }

    @Test
    public void test() {

    }


}
