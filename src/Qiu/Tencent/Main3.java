package Qiu.Tencent;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        sc.nextLine();
        Deque<Integer> que = new LinkedList();
        int cou = 0;
        while(cou<n){
            que.addLast(sc.nextInt());
            cou++;
        }
        sc.nextLine();//
        List<Integer> ans = new ArrayList();
        cou = 0;
        while(que.size()!=0){
            if(cou%2==0){ //大Q select
                if(que.peekFirst()> que.peekLast()){
                    ans.add(que.pollFirst());
                }else{
                    ans.add(que.pollLast());
                }
            }else{
                if(que.peekFirst()> que.peekLast()){
                    ans.add(que.pollLast());
                }else{
                    ans.add(que.pollFirst());
                }
            }
            cou++;
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i));
            if(i!=ans.size()-1) System.out.print(" ");
        }

    }
}
