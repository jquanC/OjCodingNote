package ACMmodel.NetEase.re;

import java.util.Scanner;

public class XYnum {
    /**此题收获：
     * 一个N进制数，不管是从头读还是从后读，都是可还原的*/
    /*
    in:
    5 2
    113221101000101
    out:
    837
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int p1 = 0;
        int p2 = str.length()-1;
        int c = 0;
        int numX=0;
        int numY=0;
        numX = numX*X+str.charAt(p1)-'0';
        numY = (int) ((str.charAt(p2)-'0')*Math.pow(Y,c))+numY;

        while(p1<p2){
            if(numX<numY){
                p1++;
                if(p1 == p2) break;
                numX = numX*X+str.charAt(p1)-'0';
            }else{
                p2--;
                if(p1 == p2) break;
                c++;
                numY = (int) ((str.charAt(p2)-'0')*Math.pow(Y,c))+numY;
            }
        }
        if(numX == numY){
            System.out.println(numX);
        }else{
            System.out.println("wrong");
        }
    }
}
