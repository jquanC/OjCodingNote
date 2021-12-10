package SwordOf.bitAlgo;

/**注意Java中没有无符号整数
 * 选对了方法，处理是一样的*/
public class HammingWeight {
    // you need to treat n as an unsigned value

    /**
     public int hammingWeight(int n) {
     int ret = 0;
     for(int i=0;i<32;i++){
     if((n&(1<<i))!=0) ret++;
     }
     return ret;
     }*/
    public int  hammingWeight(int n) {
        int ret=0;
        while(n!=0){
            n = n&(n-1);
            ret++;
        }
        return ret;
    }
}
