package Qiu.NetEase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main01_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String initial = sc.nextLine();
        initial = initial.substring(1,initial.length()-1);

        ArrayList<ArrayList<Integer>> boxs = new ArrayList();
        int start = 0;
        for(int i=0;i<initial.length();i++){
            if(initial.charAt(i)==']'){
                boxs.add(parseOneBos(initial.substring(start,i+1)));
                start = i+2;
            }
        }

        int[] openVis = new int[boxs.size()];
        HashSet<Integer> ownKey = new HashSet();
        ownKey.add(0);
        open(0,openVis,boxs,ownKey);

        if(ownKey.size()==openVis.length) System.out.println(true);
        else System.out.println(false);

    }
    public static void open(int key,int[] openVis, ArrayList<ArrayList<Integer>> boxs, HashSet<Integer> ownKey){
        if(openVis[key]==1){
            return;
        }
        openVis[key] = 1;
        if(boxs.get(key).size()!=0){
            for(Integer e:boxs.get(key)){
                ownKey.add(e);
                open(e,openVis,boxs,ownKey);
            }
        }

        return;

    }

    public static ArrayList<Integer> parseOneBos(String str){
        str = str.substring(1,str.length()-1);
        if(str==null || str.length()==0) return new ArrayList<Integer>();


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
