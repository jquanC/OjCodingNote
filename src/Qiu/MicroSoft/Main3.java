package Qiu.MicroSoft;

public class Main3 {
    public static void main(String[] args) {
        Main3 so  = new Main3();
//        int[] A = new int[]{-1,1,3,3,3,2,3,2,1,0};
//        int[] A = new int[]{1,3,5,7,9};
//        int[] A = new int[]{3,-1,-5,-9};
//        int[] A = new int[]{1,1,2,5,7};
        int[] A = new int[10000];
        int ans  =  so.solution2(A);
        System.out.println(ans);


    }
    public int solution2(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int N = A.length;
        if(N<=2) return 0;
        // write your code in C (C99 (gcc 6.2.0))
        int[] diff = new int[N];
        diff[0] = A[0];
        for(int i = 1;i<N;i++){
            diff[i] = A[i]-A[i-1];
        }
        int cou = 0;
        int i=1;
        while(i<N){
            if(i+1>=N) break;
            if(diff[i]!=diff[i+1]){
                i++;
                continue;
            }
            int j=i+1;
            while(j<N && diff[i]==diff[j]){
                j++;
            }
            //计算
            int sameLen = j-i;//at lese >=2
            if(sameLen>2){
                int tLen = sameLen+1;
//                cou += tLen-3+1+1;
                int bound = tLen -3 +1;
                cou+= ((1+bound)*bound)/2;
            }else{
                cou += 1;
            }
            if(cou>1000000000){
                return -1;
            }
            i = j;

        }
        return cou;
    }
    int solution(int A[], int N) {
        if(N<=2) return 0;
        // write your code in C (C99 (gcc 6.2.0))
        int[] diff = new int[N];
        diff[0] = A[0];
        for(int i = 1;i<N;i++){
            diff[i] = A[i]-A[i-1];
        }
        int cou = 0;
        int i=1;
        while(i<N){
            if(i+1>=N) break;
            if(diff[i]!=diff[i+1]){
                i++;
                continue;
            }
            int j=i+1;
            while(j<N && diff[i]==diff[j]){
                j++;
            }
            //计算
            int sameLen = j-i;//at lese >=2
            if(sameLen>2){
                int tLen = sameLen+1;
//                cou += tLen-3+1+1;
                int bound = tLen -3 +1;
                cou+= ((1+bound)*bound)/2;
            }else{
                cou += 1;
            }
            if(cou>1000000000){
                return -1;
            }
            i = j;

        }
        return cou;
    }
}
