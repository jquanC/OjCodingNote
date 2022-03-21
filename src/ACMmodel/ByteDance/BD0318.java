package ACMmodel.ByteDance;


import java.util.HashSet;
import java.util.Scanner;

public class BD0318 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int maxLen = 1;
        //set存储的就是一个 [i,j] 子字符串（不含重复）的每个字符
        HashSet<Character> set = new HashSet<>();
        set.add(str.charAt(0));

        int left = 0;
        for (int i = 1; i < str.length(); i++) { //i右指针
            char ch = str.charAt(i); //是否可扩展
            if (set.contains(ch)) { //重复
                //重复前面的字符都应该扔掉 [abcd] [b] ,应该扔掉 ab,
                //从左开始扫描
                for (int j = left; j < i; j++) {
                    char dropCh = str.charAt(j);
                    if (dropCh != ch) {
                        set.remove(dropCh);//删除的按index
                        // continue;
                    } else {
                        // if(dropCh == ch){
                        int curLen = i - j;//+1 -1 抵消
                        if (curLen > maxLen) maxLen = curLen;
                        set.remove(dropCh);//这里reMove 是为了后面代码统一add
                        left = j + 1;
                        set.add(ch);
                        break;
                    }
                }
                continue;
            }

            set.add(ch);
            int curLen = set.size();//i-left+1
            if (curLen > maxLen) maxLen = curLen;
        }
        System.out.println(maxLen);
    }
}

