package ACMmodel.HuaWei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        int taskNum = sc.nextInt();
        sc.nextLine();

        String oriLine = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<oriLine.length();i++){
            char ch = oriLine.charAt(i);
            if(ch=='A'||ch=='B') sb.append(ch);
        }
        String line = sb.toString();

        int aNum=0;
        int bNum=0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='A') aNum++;
            else bNum++;
        }
        int aUse = 0;
        if(aNum%4 ==0){
            aUse = aNum/4;
        }else aUse = aNum/4 +1;
        int bUse = bNum;

        if(aUse+bUse > M){
            System.out.println(0);
            System.out.println(0);
        }else{
            int cpuAIndex = 0;
            int cpuARes = 0;
            int cpuBIndex= 0;
//            int cpuBRes = 1;
            int nextCpuIndex = 1;
            for(int i=0;i<line.length();i++){
                if(line.charAt(i)=='A'){
                    if(cpuARes>0){
                        cpuARes--;
                    }else{
                        cpuAIndex = nextCpuIndex;
                        nextCpuIndex++;
                        cpuARes = 3;
                    }
                }else{
//                    if(cpuBRes>0){
//                        cpuBRes = 0;
//                    }else{
                        cpuBIndex = nextCpuIndex;
                        nextCpuIndex++;


                }
            }

            if(line.charAt(line.length()-1)=='A'){
                System.out.println(cpuAIndex);
                System.out.println(4-cpuARes);
            }else{
                System.out.println(cpuBIndex);
                System.out.println(1);
            }
        }

    }
}
