package Qiu.MeiD;

import java.util.ArrayList;

public class Main1 {
    /**
     * ["This", "is", "an", "instance", "of", "code", "alignment."],16
     * "This    is    an",
     * "instance of code",
     * "alignment.      "
     * 每一行尽可能多的单词
     * 空格尽可能均匀，不能平均左边多一点空格
     * 如果一行最多只能有一个单词，左对齐
     * 最后一行，左对齐，单词间（如果有多个）不再插入额外空格
     */
    public static void main(String[] args) {
        Main1 so = new Main1();
        String[] test = new String[]{"This", "is", "an", "instance", "of", "code", "alignment."};
        ArrayList<String> ans = so.justifyFill(test, 16);
        System.out.println(ans.toString());
    }

    public ArrayList<String> justifyFill(String[] words, int M) {
        // write code here
        int i = 0;
        int len = words.length;
        int curRealLen = 0;
        ArrayList<String> ans = new ArrayList();
        ArrayList<String> oneList = new ArrayList<>();
        while (i < len) {
            oneList.add(words[i]);
            curRealLen += words[i].length();
            if (curRealLen + oneList.size() - 1 == M) {
                String oneAns = "";
                for (int w = 0; w < oneList.size(); w++) {
                    if (w != oneList.size() - 1) oneAns += oneList.get(w) + " ";
                    else oneAns += oneList.get(w);
                }
                ans.add(oneAns);
                i++;
                oneList.clear();
                curRealLen = 0;
                continue;
            }
            if (curRealLen + oneList.size() - 1 < M) {
                i++;
                continue;
            }
            //回撤-i不用，后面也不用加
            oneList.remove(oneList.size() - 1);
            curRealLen -= words[i].length();
            //记录一次解：
            int resAddChCou = M - curRealLen;
            int addP = resAddChCou / (oneList.size() - 1);//每个字符都要加的空格数
            int addRes = resAddChCou % (oneList.size() - 1);//需要额外加1个空格的单词数，从前数;
            String kongP = "";

            for (int m = 0; m < addP; m++) kongP += " ";

            String oneAns = "";
            int couAddRes = 0;
            for (int q = 0; q < oneList.size(); q++) {
                String e = oneList.get(q);
                if (q != oneList.size() - 1) {
                    e += kongP;
                    if (couAddRes < addRes) {
                        e += " ";
                        couAddRes++;
                    }
                    oneAns += e;
                } else {
                    oneAns += e;
                }

            }

            ans.add(oneAns);
            curRealLen = 0;
            oneList.clear();
        }
        String oneAns = "";
        int lenCou = 0;
        if (oneList.size() != 0) {//还要处理最后一行
            for (String e : oneList) {
                lenCou += e.length();
                oneAns += e;
            }
        }
        for (int t = oneAns.length(); t < M; t++) {
            oneAns += " ";
        }
        ans.add(oneAns);
        return ans;
    }

}
