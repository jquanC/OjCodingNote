package ACMmodel.Ali;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestNorepeatString {
    public int longestNorepeatedSubtring(String str){
        HashSet<Character> set = new HashSet<>();
        int len = str.length();
        int maxLen = 0;
        int markPos = 0;
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                int curLen = set.size();
                if(curLen > maxLen){
                    maxLen = curLen;
                    markPos = i;
                }
            }else{
                int setLen = set.size();
                for(int j=i-setLen; j<i; j++){
                    char  cha = str.charAt(j);
                    if(cha!=ch){
                        set.remove(cha);
                    }else{
                        break;
                    }
                }

            }
        }
        String ans = str.substring(markPos+1-maxLen,markPos+1);
//        return ans;
        return maxLen;

    }
    @Test
    public void test(){
       int ans = longestNorepeatedSubtring("adbakowb");
        System.out.println(ans);
    }
/*
* 酒店有 1-100个房间， 服务员 依次 将房间进行 “开门，关门”等操作。
  操作： 100个服务员 --> 第一个将所有门打开， 第2个将 2为倍数的房间 “相反处理” ，
  第3个将 3为倍数的房间 “相反处理”，。。。当 第100个服务员来过后（及处理后），
  哪几房间是打开的，将房号依次打印出来
* */
    public void openclose(int number){ //number 房间数
        boolean[] arr = new boolean[number+1];
        //f 关门 true 开门
        for(int i=1;i<=number;i++){
            int k = i;
            int beishu = 1;
            int roomNumer = 1;
            while(roomNumer<=100){
                roomNumer = k*beishu;
                if(roomNumer<=100) arr[roomNumer] = !arr[roomNumer];
                beishu++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=number;i++){
            if(arr[i]){
                ans.add(i);
            }
        }
        System.out.println(ans.toString());

    }

    @Test
    public void test2(){
       openclose(100);

    }

}
