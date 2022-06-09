package ACMmodel.ByteDance.Andro;

import java.util.Random;

public class Rand5to7 {
    public static void main(String[] args) {

    }
    public int rand7(){
        //第一部分等概率生成：0 5 10 15 20
        //加上第二部分，整体等概率的生成：[1,25]
        int ans =0x3f3f3f3f;
        //优化前
       /* if(ans >7){
            ans = 5*(rand5()-1)+rand5();
        }
        return ans;*/
        //优化后
        if(ans >21){ //可以取最接近25的7的倍数
            ans = 5*(rand5()-1)+rand5();
        }
        return ans%7;

    }
    /**return [1,5]*/
    public int rand5(){
        Random random = new Random();
        return random.nextInt(5)+1;
    }
}
