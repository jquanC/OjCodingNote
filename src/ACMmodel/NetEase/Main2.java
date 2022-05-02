package ACMmodel.NetEase;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 4*n;
        char[][] arr = new char[4*n+1][4*n+1];


        for(int i=1;i<=2*n;i++){
            int dotCou = n-i+1;
            int starCou=-1;
            boolean change = false;
            if(dotCou<=0){
                change = true;
                starCou =n;
            }
            for(int j=1;j<=4*n;j++){
                if(j<=2*n){
                    if(!change){
                        if(dotCou>0){
                            arr[i][j]= '.';
                            dotCou--;
                        }else arr[i][j] = '*';
                    }else{
                        if(starCou>0){
                            arr[i][j] = '*';
                            starCou--;
                        }else arr[i][j] = '.';
                    }

                }else{
                    arr[i][j] = arr[i][len+1-j];
                }
            }
        }
        for(int i=2*n+1;i<=4*n;i++){
            for(int j=1;j<=4*n;j++){
                arr[i][j] = arr[len+1-i][j];
            }
        }
        for(int i=1;i<=4*n;i++){
            for(int j=1;j<=4*n;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
