package ACMmodel.TenCent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] srr = new String[n];
        for(int i=0;i<n;i++){
            srr[i] = sc.nextLine();
        }
        char[][] crr = new char[n][];
        for(int i=0;i<n;i++){
            crr[i] = srr[i].toCharArray();
        }
        HashSet<Integer> set = new HashSet<>();
        int slen = srr[0].length();
        for(int i=0;i<slen;i++){
            StringBuilder sb = new StringBuilder();
            boolean preZ = true;
            for(int j=0;j<n;j++){
                if( preZ && crr[j][i]!='0'){ //
                    preZ = false;
                }
                if(preZ==false){
                    sb.append(crr[j][i]);
                }
            }
            String nstr = sb.toString();
            int curNum = Integer.parseInt(nstr);
            set.add(curNum);
        }
        int[] nums = new int[set.size()];
        int index = 0;
        for(int e:set){
            nums[index] = e;
            index++;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
            if(i!=nums.length-1) System.out.print(" ");
        }
        return;

    }
}
