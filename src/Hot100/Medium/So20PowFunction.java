package Hot100.Medium;

public class So20PowFunction {
    public double myPow(double x, int n) {
        long N = n;
        //if (N == 0) return 1.0; //其实没必要，可注释
        return N > 0 ? recurMul(x, N) : 1 / recurMul(x, -N);

    }

    private double recurMul(double x, long n) {
        if(n == 0 ) return 1.0;
        double y = recurMul(x,n/2);
        return n%2==0? y*y : y*y*x;
    }
    /*public double myPow(double x , int n){
        long N = n;
        if(N ==0 ) return 1.0; //其实没必要，可注释

        return N>0? quickMul(x,N) : 1/quickMul(x,-N);

    }*/
    //快速幂乘迭代方法1
    /*private double quickMul(double x ,int n){
        double x_contributor = x;
        double res=1.0;
        String nBinaryStr = Integer.toBinaryString(n);

        for(int i=nBinaryStr.length()-1 ; i>=0 ; i--){
            char makeSense = nBinaryStr.charAt(i);
            if(makeSense == '1'){
                res = res*x_contributor;
            }
            x_contributor *= x_contributor;
        }
        return res;
    }*/
    //快速幂乘迭代方法2
   /* private double quickMul(double x ,long n){
        double res =1.0;
        double x_contributor = x;
        while(n>0){
            if(n%2 == 1 ){
                res = res*x_contributor;
            }
            x_contributor *= x_contributor;
            n /= 2;
        }
    return res;
    }*/
}
