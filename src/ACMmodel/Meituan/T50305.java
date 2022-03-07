package ACMmodel.Meituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * - 输入n, 表示字符串的 长度和字符串 。输入t ，表示猜测的次数。  字符串由 数字字符组成。输入t个 字符串 ， 用于猜测目标字符串 tar 。 a 表示 有多少位置上的字符相同。 b 表示 t 中有多少个数字在 s中出现但位置是错的；
 * - 输出能否猜出字符串 tar ，不行打印-1*/
public class T50305 {
    static boolean ok = false;
    static char[] tar;
    static int [] use;
    static int n;
    static int t;
    static int[][]ab;
    static String[] arr;
    static String ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        sc.nextLine();
        tar = new char[n];
        use = new int[10];

        arr = new String[t];
        ab = new int[t][2];
        for(int i=0;i<t;i++){
            arr[i] = sc.next();
            ab[i][0] = sc.nextInt();
            ab[i][1] = sc.nextInt();
            sc.nextLine();
        }
        dfs(0);
        if(!ok) System.out.println("?");
        else System.out.println(ans);

    }
    public static void dfs(int pos){

        if(pos == n){
            if(check()){
                ok = true;
                ans = String.valueOf(tar);
                return;
            }
            return;
        }

        for(int i=0;i<=9;i++){

            if(use[i] == 0 ){
                if(pos ==0 && i==0) continue;

                tar[pos] = (char)('0'+i);
                use[i] = 1;
                dfs(pos+1);
                use[i] = 0;
            }
            if(ok == true) return;
        }
    }
    public static boolean check(){

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

}

