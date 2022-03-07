package Blank;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='x'||ch=='y'||ch=='z'){
                sb.append(ch);
            }
        }
        int[] cutPos = new int[sb.length()];
        for(int i=0;i<sb.length();i++){
            cutPos[i] = sc.nextInt();
        }
        sc.nextLine();
        int stX = 0,edX=n;
        int stY = 0,edY=n;
        int stZ = 0,edZ=n;
        int[] ans = new int[m];
        for(int i=0;i<sb.length();i++){
            char op = sb.charAt(i);
            if(op=='x'){
                int pos = cutPos[i];
                if(pos>stX && pos<edX){
                    if(pos-stX > edX-pos){
                        edX = pos;
                    }else{
                        stX = pos;
                    }
                }
                ans[i] = (edX-stX)*(edY-stY)*(edZ-stZ);
            }
            if(op=='y'){
                int pos = cutPos[i];
                if(pos>stY && pos<edY){
                    if(pos-stY > edY-pos){
                        edY = pos;
                    }else{
                        stY = pos;
                    }
                }
                ans[i] = (edX-stX)*(edY-stY)*(edZ-stZ);

            }
            if(op=='z'){
                int pos = cutPos[i];
                if(pos>stZ && pos<edZ){
                    if(pos-stZ > edZ-pos){
                        edZ = pos;
                    }else{
                        stZ = pos;
                    }
                }
                ans[i] = (edX-stX)*(edY-stY)*(edZ-stZ);

            }
        }
        for(int i=0;i<m;i++){
            System.out.println(ans[i]);
        }

    }


}