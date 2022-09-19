package Qiu.BAIDU;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Mainq1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashSet<Character> yuanSet = new HashSet();
        yuanSet.add('a');
        yuanSet.add('e');
        yuanSet.add('i');
        yuanSet.add('o');
        yuanSet.add('u');
        HashSet<Character> wdwSet = new HashSet();
        char[] crr = str.toCharArray();
        int cou = 0;
        for(int i=0;i<crr.length;i++){
            if(yuanSet.contains(crr[i])) continue;

            //开启一次判断
            if(i+4<crr.length && !yuanSet.contains(crr[i+3]) && yuanSet.contains(crr[i+1])
                    &&yuanSet.contains(crr[i+2]) && yuanSet.contains(crr[i+4]) ){
                HashSet<Character> uni = new HashSet();
//                ArrayList<Character> ansList = new ArrayList();
                boolean find = true;
                for(int j=i;j<i+5;j++){
                    if(uni.contains(crr[j])){
                        find = false;
                        break;
                    }
                    uni.add(crr[j]);
//                    ansList.add(crr[j]);
                }
                if(find){
                    cou++;
//                    System.out.println(ansList.toString());
                }
                i+=2;
            }

        }
        System.out.println(cou);

    }
}
