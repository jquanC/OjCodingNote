package Qiu.MicroSoft;

import java.util.HashMap;

public class Main2_2 {
    public static void main(String[] args) {
        Main2_2 so = new Main2_2();
        int[] A = new int[]{2,-2,3,0,4,-7};
        int ans = so.subarraySum(A);
        System.out.println(ans);
    }

    public int subarraySum(int[] A) {
        int cou = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            pre += A[i];
            if (map.containsKey(pre)) {
                cou += map.get(pre);
                if(cou>1000000000){
                    cou = -1;
                    break;
                }
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cou;
    }


}
