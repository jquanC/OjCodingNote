package Qiu.JD;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    /**
     * 特殊情況：
     * 1 奇 偶位置出現次數最大的數是一樣的情況：看誰出現更多
     *   奇、偶各自記錄前2次數的數
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        HashMap<Integer, Integer> mapJi = new HashMap();
        HashMap<Integer, Integer> mapOu = new HashMap();
        mapJi.put(0,0);
        mapOu.put(0,0);
        int maxJi = 0;
        int maxJiNum=0;
        int lastMaxNumJi = 0;
        //
        int maxOu = 0;
        int maxOuNum=0;
        int lastMaxNumOu = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int t = mapOu.getOrDefault(arr[i], 0) + 1;
                mapOu.put(arr[i], t);
                if(t>maxOu && maxOuNum == arr[i]) maxOu = t;
                if(t>maxOu && maxOuNum != arr[i]){
                    maxOu = t;
                    lastMaxNumOu = maxOuNum;
                    maxOuNum = arr[i];
                }
            }else{
                int t = mapJi.getOrDefault(arr[i], 0) + 1;
                mapJi.put(arr[i], t);
                if(t>maxJi && maxJiNum == arr[i]) maxJi = t;
                if(t>maxJi && maxJiNum != arr[i]){
                    maxJi = t;
                    lastMaxNumJi = maxJiNum;
                    maxJiNum = arr[i];
                }
            }

        }
        //需要遍历map
        int reachMaxJiCou = 0;
        for(Integer e:mapJi.keySet() ){
            if(mapJi.get(e)==maxJi) reachMaxJiCou++;
        }
        int reachMaxOuCou = 0;
        for(Integer e:mapOu.keySet() ){
            if(mapOu.get(e)==maxOu) reachMaxOuCou++;
        }
        if(maxOuNum !=maxJiNum || reachMaxJiCou>=2||reachMaxOuCou>=2){
            int ans = (n/2)-maxJi+(n-n/2)-maxOu;
            System.out.println(ans);
            return;
        }
        if(maxOu>maxJi){ //choose maxOuNum
            int ouChange = (n-n/2)-maxOu;
            int jiChange = (n/2)-mapJi.get(lastMaxNumJi);
            System.out.println(ouChange+jiChange);
        }else{
            int ouChange = (n-n/2)-mapOu.get(lastMaxNumOu);
            int jiChange = (n/2)-maxJi;
            System.out.println(ouChange+jiChange);
        }

    }
}
