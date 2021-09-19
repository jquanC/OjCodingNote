package CSP;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int[][] input = new int[m][m];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
            hashMap.put(input[i][0], -1);
        }

        int maxCou = Integer.MIN_VALUE;
        int maxE = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()
        ) {

            int cou = 0;
            int e = entry.getKey();
            for (int i = 0; i < m; i++) {
                if ((input[i][0] >= e && input[i][1] == 1) || (input[i][0] < e && input[i][1] == 0)) {
                    cou++;
                }
            }
            if (cou > maxCou) {
                maxCou = cou;
                maxE = e;
            } else if (cou == maxCou && e > maxE) {
                maxE = e;
            }
        }

        System.out.println(maxE);
    }

}




