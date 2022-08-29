package Qiu.Q360;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    static HashSet<String> setSubject = new HashSet();
    static HashSet<String> setVer = new HashSet();
    static HashSet<String> setObject = new HashSet();
    static String ansYes = new String("YES");
    static  String ansNo = new String("NO");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        sc.nextLine();

        String subLine = sc.nextLine();
        String[] subLines = subLine.split(" ");
        for(int i=0;i<subLines.length;i++){
            setSubject.add(subLines[i]);
        }
        String verLine = sc.nextLine();
        String[] verLines = verLine.split(" ");
        for(int i=0;i<verLines.length;i++){
           setVer.add(verLines[i]);
        }
        String objLine = sc.nextLine();
        String[] objLines = objLine.split(" ");
        for(int i=0;i<objLines.length;i++){
            setObject.add(objLines[i]);
        }
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ans = new ArrayList();
        for(int i=0;i<m;i++){
            ans.add(cal(sc.nextLine()));
        }
        for(String e:ans) System.out.println(e);

    }
    public static String cal(String sentence){
        String[] sens = sentence.split(" ");
        boolean findSub=false;
        boolean findVer = false;
        boolean findObj = false;
        for(int i=0;i<sens.length;i++){
            if(!findSub){
                if(!setSubject.contains(sens[i])) return ansNo;
                findSub = true;
                continue;
            }
            if(findSub && !findVer){
                if(setSubject.contains(sens[i])) continue;
                if(!setVer.contains(sens[i])) return ansNo;
                findVer = true;
                continue;
            }
            if(findSub && findVer && !findObj){
                if(setSubject.contains(sens[i]) || setVer.contains(sens[i])) return ansNo;
                if(!setObject.contains(sens[i])) return ansNo;
                findObj = true;
                continue;
            }
            if(findObj && findSub && findVer){
                if(!setObject.contains(sens[i])) return ansNo;
                continue;

            }

        }
        return ansYes;
    }
}
