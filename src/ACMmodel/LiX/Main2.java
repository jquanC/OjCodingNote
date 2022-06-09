package ACMmodel.LiX;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**统计食物链的条数*/
public class Main2 {
    public static  int cou = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer>[] outEdges = new ArrayList[n+10];
//        ArrayList<Integer>[] inEdges = new ArrayList[n+10];
        for(int i=0;i<n+10;i++){
            outEdges[i] = new ArrayList<>();
//            inEdges[i] = new ArrayList<>();
        }
        int[] inDegreeCou = new int[n+10];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            outEdges[a].add(b);
            inDegreeCou[b]++;
        }

        for(int i=1;i<=n;i++){
           if(inDegreeCou[i]==0){
               searchLink(i,1,outEdges);
           }
        }
        System.out.println(cou);
    }
    public static void searchLink(int startFromCur,int step, ArrayList<Integer>[] outEdges){
        if(outEdges[startFromCur].size()==0 ){
            if(step !=1 ) cou++;
            return;
        }
        for(int e: outEdges[startFromCur]){
            searchLink(e,step+1,outEdges);
        }

    }
}
