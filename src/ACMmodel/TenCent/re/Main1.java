package ACMmodel.TenCent.re;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for(int i=0;i<n;i++){
            strs[i] = sc.nextLine();
        }
        int m = strs[0].length();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            int x = 0;
            for(int j=0;j<n;j++){
                x += x*10+strs[j].charAt(i);
            }
            ans.add(x);
        }
        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i=0;i<ans.size();i++){
            if(i!=ans.size()-1) System.out.print(ans.get(i)+" ");
            else System.out.println(ans.get(i));
        }

    }
}
