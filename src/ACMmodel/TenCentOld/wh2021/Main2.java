package ACMmodel.TenCentOld.wh2021;


import javax.swing.plaf.SeparatorUI;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int k = sc.nextInt();
        PriorityQueue<String> que = new PriorityQueue<>((a,b)->(b.compareTo(a)));
        HashSet<String> set = new HashSet<>();
        //优化1 第k小的串长度不会长于k
        for(int len = 1;len<=k;len++){
            for(int i=0;i<length-len+1;i++){//length-len+1
                String subStr = str.substring(i,i+len);
                if(set.contains(subStr)) continue;
                else set.add(subStr);

                if(que.size()<k){
                    que.offer(subStr);
                }else{
                    String queMax = que.peek();
                    /*if(queMax.compareTo(subStr)>0) ;//if（）后加“；”，不管（）里的是否为真，都会执行后面{}里的内容
                    else{
                        que.poll();
                        que.offer(subStr);
                    }*/
                    if(subStr.compareTo(queMax)<0){
                        que.poll();
                        que.offer(subStr);
                    }
                }
            }
        }
        System.out.println(que.peek());
    }
}
