package Qiu.MEIT;


import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int matchLevel = (n+1)/2;

       /* int[] ini_p = new int[n];
        int[] ini_n = new int[n];*/
        HashMap<Integer,Integer>  posMap = new HashMap();
        HashMap<Integer,Integer>  negMap = new HashMap();

        for(int i=0;i<n;i++){
            int t = sc.nextInt();
            posMap.put(t,posMap.getOrDefault(t,0)+1);
        }
        sc.nextLine();
        for(int i=0;i<n;i++){
            int t = sc.nextInt();
            negMap.put(t,negMap.getOrDefault(t,0)+1);
        }
        int ans = 0x3f3f3f3f;
        boolean find = false;
        for(Integer e : posMap.keySet()){
            int cou = posMap.get(e);
            if(cou>=matchLevel){
                ans = 0;
                find = true;
                break;
            }
            if(negMap.containsKey(e)){
                int negCou = negMap.get(e);
                if(cou+negCou>=matchLevel && negCou <ans){
                    find = true;
                    ans = negCou;
                }
            }

        }
        if(!find){
            for(Integer e: negMap.keySet()){
                if(negMap.get(e)>=matchLevel){
                    ans = matchLevel;
                    find = true;
                    break;
                }
            }
        }
        if(find) System.out.println(ans);
        else System.out.println(-1);




    }


}
