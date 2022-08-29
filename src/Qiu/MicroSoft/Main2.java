package Qiu.MicroSoft;

public class Main2 {
    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for(int i = 1;i<A.length;i++){
            sum[i] = sum[i-1]+A[i];
        }
        //[i,j]  = sum[j]-sum[i-1]
        int cou = 0;
        for(int i=0;i<A.length;i++){//枚举左端点
            for(int j=i;j<A.length;j++){
                if(i==j){
                    if(A[i]==0){
                        cou++;
                        //
                        if(cou>1000000000) return -1;
                    }
                    continue;
                }
                if(i!=0 && sum[j]-sum[i-1]==0){
                    cou++;
                    //
                    if(cou>1000000000) return -1;
                    continue;
                }
                if(i==0 && sum[j]==0){
                    cou++;
                    //
                    if(cou>1000000000) return -1;
                    continue;
                }
            }
        }
        return cou;
    }
}
