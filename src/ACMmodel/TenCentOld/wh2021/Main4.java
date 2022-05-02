package ACMmodel.TenCentOld.wh2021;

import java.util.Scanner;

public class Main4 {
    static int [] que = new int[1000000];
    static int head=-1;
    static int tail=-1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        String[][] ops = new String[T][];
        sc.nextLine();
        for(int i=0;i<T;i++){
            int Q = sc.nextInt();
            sc.nextLine();
             ops[i] = new String[Q];
            for(int j=0;j<Q;j++){
               ops[i][j] = sc.nextLine();
            }
        }
        for(int i =0;i<T;i++){
            head = -1;
            tail = -1;
            cal(ops[i]);
        }

    }
    public static void cal(String[] ops){

        for(int i=0;i<ops.length;i++){
            String str = ops[i];
            if(str.contains("PUSH")){
//                int ele = str.charAt(str.length()-1)-'0';//如果是 PUSH 21 咋搞！
                String[] strs = str.trim().split(" ");
                int ele = Integer.parseInt( strs[1]);
                tail++;
                que[tail] = ele;
            }else if(str.contains("TOP")){
                if(head+1<=tail){
                    System.out.println(que[head+1]);
                }else System.out.println(-1);
            }else if(str.contains("POP")){
                if(head+1<=tail){
//                        System.out.println(que[head+1]);
                    head++;
                }else System.out.println(-1);
            }else if(str.contains("SIZE")){
                System.out.println(tail-head);
            }else{
                head = -1;
                tail = -1;
            }
        }

    }
}
