package ACMmodel.TenCentOld.fall2021;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        int ans=0;
//        List<List<Integer>> ansList = new ArrayList<>();
        for(int len = 2;len<=n;len++){
            PriorityQueue<Integer> que = new PriorityQueue<Integer>();
            for(int t = 0;t<len-1;t++) que.add(arr[t]);
            int j = len -1;
            for(int i=0;i+len-1<n;i++){
                que.add(arr[j]); //为了代码统一
                int leftNum = arr[i];
                int rightNum = arr[j];
                int minNum = que.poll();
                int min2Num = que.poll();
                if((leftNum == minNum && rightNum==min2Num) ||
                        (leftNum==min2Num && rightNum == minNum)){
                    ans++;
                    //恢复队列 大if进来必然是此2种情况之一
                    if(leftNum == minNum) que.add(min2Num);
                    else if(leftNum == min2Num) que.add(minNum);

                    //记录下解
                   /* List<Integer> oneans = new ArrayList<>();
                    for(int m=i;m<=j;m++) oneans.add(arr[m]);
                    ansList.add(oneans);*/
                }else{
                    //先add回去再删除，因为要删除的可能是minNum 和 min2Num 之一
                    que.add(min2Num);
                    que.add(minNum);
                    que.remove(leftNum);
                }
                j++;
            }
        }
        System.out.println(ans);
        /*for(List<Integer> e:ansList){
            System.out.println(e.toString());
        }*/


    }
}
