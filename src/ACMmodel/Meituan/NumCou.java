package ACMmodel.Meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * He15l154lo87wor7l87d
 * */
public class NumCou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> ans = new ArrayList<>();
        int x=0;
        for(int i=0;i<s.length();i++ ){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                if(x!=0){
                    ans.add(x);
                    x = 0;
                }
            }
            else{
                x = x*10+(s.charAt(i) - '0');
            }
        }
        //数字在最后的情况，加进去
        if(x!=0) ans.add(x);
        System.out.println(ans);

    }
}
