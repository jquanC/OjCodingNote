package Qiu.NetEase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String initial = sc.nextLine();
        initial = initial.substring(1,initial.length()-1);
//        System.out.println(initial);
        ArrayList<ArrayList<Integer>> boxs = new ArrayList();
        int start = 0;
        for(int i=0;i<initial.length();i++){
            if(initial.charAt(i)==']'){
                boxs.add(parseOneBos(initial.substring(start,i+1)));
                start = i+2;
            }
        }
//        boxs.add(parseOneBos(initial.substring(start)));
       /* for(ArrayList<Integer> e:boxs){
            System.out.println(e.toString());
        }*/
        int[] openVis = new int[boxs.size()];
        HashSet<Integer> ownKey = new HashSet();
        ownKey.add(0);
        for(Integer e:boxs.get(0)){
            ownKey.add(e);
        }
        openVis[0] = 1;
        boolean findNew = true;
        while (findNew) {
            findNew = false;
            for(Integer e:ownKey){
                if(openVis[e]==0){
                    findNew = true;
                    openVis[e] = 1;
                    if(boxs.get(e).size()!=0){
                        for(Integer t:boxs.get(e)){
                            ownKey.add(t);
                        }
                    }

                }

            }
        }
        if(ownKey.size()==boxs.size()) System.out.println(true);
        else System.out.println(false);





    }

    public static ArrayList<Integer> parseOneBos(String str){
        str = str.substring(1,str.length()-1);
        if(str==null || str.length()==0) return new ArrayList<Integer>();

//        System.out.println("mk:"+str);
        ArrayList<Integer> ans = new ArrayList();
        if(str.contains(",")){
            String[] ns = str.split(",");
            for(String e: ns){
                ans.add(Integer.parseInt(e));
            }
            return ans;
        }else{
             ans.add(Integer.parseInt(str));
             return  ans;
        }
    }
}
