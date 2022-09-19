package Qiu.BAIDU;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> forIF = new Stack();
        Stack<Character> forStk = new Stack();
        Stack<Character> ifStk = new Stack();
        int max = 0;
        int breakCou = 0;
//        int see = 0;
        while(sc.hasNextLine()){
//            System.out.println(see++);
            String curLine = sc.nextLine();
//            System.out.println(curLine);
            char[] curCrr = curLine.toCharArray();
            for(int i=0;i<curCrr.length;i++){
                if( !(curCrr[i]=='f'||curCrr[i]=='i' || curCrr[i]=='}')) continue;
//                System.out.println("mk:l1");
                if(i+2<curCrr.length && curCrr[i]=='f' && curCrr[i+1]=='o'&&curCrr[i+2]=='r'){
//                    System.out.println("mk:l2");
                    forStk.add('{');
                    forIF.add('f');
                    max = Math.max(max,forStk.size());
                }
                if(i+1<curCrr.length && curCrr[i]=='i' && curCrr[i+1]=='f'){
//                    System.out.println("mk:l3");
                    ifStk.add('{');
                    forIF.add('i');
                }
                if(curCrr[i]=='}'){
                    if(!forIF.isEmpty()){
                        if(forIF.peek()=='f'){
                            forStk.pop();
                        }else{
                            ifStk.pop();
                        }
                        forIF.pop();
                    }
                    breakCou++;
                }

            }
//            System.out.println("beeak="+breakCou);
            if(breakCou == 2) break;
        }
        sc.nextLine();
        System.out.println(max);
    }
}
