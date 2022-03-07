package ACMmodel.Meituan;

import com.sun.javaws.IconUtil;
import org.junit.Test;

import java.util.HashMap;

public class TestT5 {
    int n =4,t=5;
    public boolean check(char[]tar,String[]arr,int[][]ab){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(tar[i],i);
        }

        for(int i=0;i<t;i++){
            String cur = arr[i];
            int a=0,b=0;
            for(int j=0;j<cur.length();j++){
                char ch = cur.charAt(j);
                if(!map.containsKey(ch)) continue;
                else{
                    if(map.get(ch) == j) a++;
                    else b++;
                }
            }
            if(a!=ab[i][0] || b!=ab[i][1]) return false;
        }
        return true;

    }
    @Test
    public void test(){
        boolean ans = false;
        char[] tar = new char[]{'1','2','8','4'};
        String[] arr = new String[]{"1234","1254","5678","5679","5690"};
        int[][]ab = new int[][]{{3,0},{3,0},{0,1},{0,0},{0,0}};
        ans = check(tar,arr,ab);

        if(ans) System.out.println(String.valueOf(tar));
        else System.out.println("?");
    }
}
