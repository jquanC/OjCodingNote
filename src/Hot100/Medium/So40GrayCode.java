package Hot100.Medium;

import java.util.ArrayList;
import java.util.List;

public class So40GrayCode {
    public List<Integer> grayCode(int n){
        /*List<String> grayCode =  dfsGrayCodeBuilder(n);
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<grayCode.size();i++){
            res.add(Integer.parseInt(grayCode.get(i),2));
        }
        return res;*/
        List<Integer> res = new ArrayList<Integer>(){
            {add(0);}
        };// 初始化 0
        int head = 1 ;
        for(int i=0;i<n;i++){ // n位gray码需要镜像构造n次
            for(int j=res.size()-1;j>=0;j--)
                res.add(head+res.get(j)); // G‘(n) 由G（n）前面加0得到，结果值相同无需构造；每次只需通过G（n）的逆序R(n),在前面+1构造R('n)

            head<<=1; //head = head>>1; 每次head后面多加个0: 1, 10 , 100 , 1000 ,....
        }
        return res;

    }
    List<String> dfsGrayCodeBuilder(int n){
        List<String> ans;
        if(n == 1){
            ans = new ArrayList<>();
            ans.add("0");
            ans.add("1");
        }else{
            ans = dfsGrayCodeBuilder(n - 1);
            int oldSize = ans.size();
            String[] x = new String[oldSize];
            String temp;
            for(int i=0;i<oldSize;i++){
                x[i] = ans.get(i);
                temp ="0"+ ans.get(i);
                ans.set(i,temp);
            }
            for(int i=oldSize-1;i>=0;i--){
                ans.add("1"+x[i]);
            }
        }
        return  ans;

    }
}
