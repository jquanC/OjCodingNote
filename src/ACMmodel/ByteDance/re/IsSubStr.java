package ACMmodel.ByteDance.re;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class IsSubStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            ans.add( isSub(strs[0],strs[1]));

        }
        System.out.println(ans);

    }
    public static boolean isSub(String s1,String s2){
        int[] cou = new int[26];
        int[] subCou = new int[26];
        HashSet<Character> s1Set = new HashSet<>();
        HashSet<Character> s2Set = new HashSet<>();
        for(int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            s1Set.add(c1);
            s2Set.add(c2);
            cou[c1-'a']++;
            subCou[c2-'a']++;
        }
        int s1Length = s1.length();
        for(int i=s1.length();i<s2.length();i++){
            char c = s2.charAt(i);
            if(s1Set.size() == s2Set.size()){
                //判断每个字符数量是否一直
                boolean find = true;
                for(char e:s1Set){
                    if(cou[e-'a'] != subCou[e-'a']){
                        find = false;
                        break;
                    }
                }
                if(find) return true;
            }else{
                s2Set.remove(s2.charAt(i-s1Length));
                s2Set.add(c);
                subCou[s2.charAt(i-s1Length)-'a']--;
                subCou[c-'a']++;
            }
        }
        return false;

    }
}
