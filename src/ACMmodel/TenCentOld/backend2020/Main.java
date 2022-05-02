package ACMmodel.TenCentOld.backend2020;

import com.sun.corba.se.spi.ior.IdentifiableContainerBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(decode(str));

    }
    /**
     * 不仅仅要考虑从 **[**[**[**]**]**] 类型
     * 还要考虑从 **[**[**[**]**]**] **[**[**[**]**]**] 类型
     * */
    public static String decode(String str){
        if(str.contains("[")){
            int startMark = -1;
            int endMark=-1;
            int expect = -1;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) =='['&& startMark == -1){
                    startMark = i;
                    expect++;
                    continue;
                }
                if(str.charAt(i)=='['){
                    expect++;
                    continue;
                }
                if(str.charAt(i)==']'&&expect == 0 ){
                    endMark = i;
                    break;
                }
                if(str.charAt(i)==']'){
                    expect--;
                }

            }
            String subDecode = decode(str.substring(startMark+1,endMark));
//            str = str.substring(0,startMark)+subDecode+str.substring(endMark+1);
            str = str.substring(0,startMark)+subDecode+decode( str.substring(endMark+1));
        }
        if(str.contains("|")){
            int pos = str.indexOf('|');
            String repeatBody = str.substring(pos+1); //repeatedBody 的后界不是
            int k = Integer.parseInt(str.substring(0,pos)); //注意数字可能不是 1位！
            String ans = "";
            for(int i=1;i<=k;i++){
                ans +=repeatBody;
            }
            return ans;
        }else{
            return str;
        }

    }
}
