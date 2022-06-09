package ACMmodel.LiX;

import java.util.*;

public class Mian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<T;i++){
            ans.add(cal(sc.nextLine()));
        }
        for(int e:ans){
            System.out.println(e);
        }

    }
    public static int cal(String  str){
        int len = str.length();
        int i=0,j=0;
        HashSet<Character> tarSet = new HashSet<>();
        tarSet.add('L');
        tarSet.add('O');
        tarSet.add('V');
        tarSet.add('E');
        HashSet<Character> curSet = new HashSet<>();
        int cou = 0;
        while(i<=j && j<=len){
            if(findLove(curSet)){
                //i 定，后面的全加
                cou += len-j +1;
                char rmChar = str.charAt(i);
                i++;
                if(tarSet.contains( rmChar)){
                    curSet.remove(rmChar);
                }
            }else{
                if(j == len) break;
                char c = str.charAt(j);
                if(tarSet.contains(c) ){
                    curSet.add(c);
                }
                j++;
            }
        }
        return cou;
    }
    //O(n)
    public static boolean findLove(HashSet<Character> set){
        if(set.size()==4){
            if(set.contains('L') && set.contains('O')&&
                    set.contains('V')&&set.contains('E')){
                return true;
            }
        }
        return false;
    }
}
