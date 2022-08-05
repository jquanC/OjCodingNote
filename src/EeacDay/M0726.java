package EeacDay;

import org.junit.Test;

import java.util.LinkedList;

public class M0726 {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int cw = 0;
        LinkedList<Character> que = new LinkedList();

        while(p1>=0 && p2>=0){
            int n1 = num1.charAt(p1)-'0';
            int n2 = num2.charAt(p2)-'0';
            if(n1+n2+cw>=10){
                int n = (n1+n2+cw)%10;
                cw = 1;
                que.offerFirst((char)('0'+n));
            }else{
                int n = (n1+n2+cw)%10;
                cw = 0;
                que.offerFirst((char)('0'+n));
            }
            p1--;
            p2--;
        }

        while(p1>=0){
            int n1 = num1.charAt(p1)-'0';
            int n = (n1+cw)%10;
            if(n1+cw>=10) cw=1;
            else cw = 0;

            que.offerFirst((char)('0'+n));
            p1--;

        }
        while(p2>=0){
            int n2 = num2.charAt(p2)-'0';
            int n = (n2+cw)%10;
            if(n2+cw>=10) cw=1;
            else cw = 0;

            que.offerFirst((char)('0'+n));
            p2--;
        }
        if(cw == 1) que.offerFirst('1');

        StringBuilder sb = new StringBuilder();
        for(Character e:que){
            sb.append(e);
        }
        return sb.toString();


    }
    @Test
    public void test(){
       M0726 so = new M0726();
       String num1 = "11";
       String num2 = "123";
       String ans = so.addStrings(num1,num2);
        System.out.println(ans);
    }
}
