package Qiu.MEIT;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 每个数据身份标识是 index;
 * 数据有自己的类型：type
 * 需要统计每个类型的数据数量：typeCou; HashMap<type,cou>
 * 遍历一遍数组：判断当前数据是在 训练集还是测试集即可：需要维护一个 usedTypeCou[],记录当前该类型划分到训练集的个数
 */

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        HashMap<Integer,Integer>  typeMap = new HashMap();
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
            int curType = sc.nextInt();
            arr[i+1] = curType;
            typeMap.put(curType,typeMap.getOrDefault(curType,0)+1);
        }
        int[] usedToTrainTypeCou = new int[k+1];
        ArrayList<Integer> trainSet = new ArrayList();
        ArrayList<Integer> testSet = new ArrayList();
        for(int i=1;i<=n;i++){
            int type = arr[i];
            if(usedToTrainTypeCou[type]< (typeMap.get(type)+1)/2){//划分训练集合
                trainSet.add(i);
                usedToTrainTypeCou[type]++;
            }else{
                testSet.add(i);
            }
        }
        for(int i=0;i<trainSet.size();i++){
            System.out.print(trainSet.get(i));
            if(i!=trainSet.size()-1) System.out.print(" ");
        }
        System.out.println();
        for(int i=0;i<testSet.size();i++){
            System.out.print(testSet.get(i));
            if(i!=testSet.size()-1) System.out.print(" ");
        }


    }


}
