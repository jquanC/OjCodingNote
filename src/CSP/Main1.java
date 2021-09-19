package CSP;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arg = new int[3];
        for(int i=0;i<3;i++){
            arg[i] = scanner.nextInt();//输入 n、m、L
        }


        int L = arg[2];
        int n = arg[0];
        int m = arg[1];

        int[][] A = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                A[i][j] = scanner.nextInt();
            }
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int cou;
                cou = hashMap.getOrDefault(A[i][j],0);
                hashMap.put(A[i][j],cou+1);
            }
        }

        for(int i=0;i<L;i++){
            int res = hashMap.getOrDefault(i,0);
           if(i == L-1){
               if(res == 0) System.out.print(0);
               else System.out.print(res);
           }else{
               if(res == 0) System.out.print(0+" ");
               else System.out.print(res+" ");
           }

        }


    }
}
