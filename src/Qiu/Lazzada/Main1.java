package Qiu.Lazzada;

import java.util.Scanner;
/**
 英文字母、空格、数字、其他字符的个数
 * */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     /*   String line = "nihao哈12哈 a?b";
        System.out.println("len= " +line.length());
        for(int i=0;i<line.length();i++){
            char ch = line.charAt(i);
            System.out.println("ch= "+ch+", ch is letter?: "+Character.isLetter(ch));
        }*/
        String line = sc.nextLine();
        int letterCou = 0;
        int digitCou = 0;
        int spaceCou = 0;
        int otherCou = 0;
        for(int i=0;i<line.length();i++){
            char ch = line.charAt(i);
            if(Character.isLetter(ch)){
                letterCou++;
            }else if(Character.isDigit(ch)){
                digitCou++;
            }else if(ch == ' '){
                spaceCou++;
            }else{
                otherCou++;
            }
        }

        System.out.println("字母的个数为:"+letterCou);
        System.out.println("数字的个数为:"+digitCou);
        System.out.println("空格的个数为:"+spaceCou);
        System.out.println("其他字符个数:"+otherCou);

    }
}
