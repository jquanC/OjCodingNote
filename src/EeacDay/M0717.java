package EeacDay;

import Hot100.Medium.STDSoZString03;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//140. 单词拆分 II hard
public class M0717 {
    public static void main(String[] args) {
        M0717 so = new M0717();
//        String s = "catsanddog";
//        String s = "pineapplepenapple";
        String s = "aaaaaaa";//7
        List<String> wordDict = new ArrayList<>();
      /*  wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");*/

      /*  wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");*/
        wordDict.add("aaaa");
        wordDict.add("aa");
        wordDict.add("a");




        List<String > ans =  so.wordBreak(s,wordDict);
        System.out.println(ans);
    }
    //构建 wordDict 字典树
    Trie tree;
    List<String> res ;
    HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        tree = new Trie();
        for(String e: wordDict) tree.addWord(e);
        res = new ArrayList<>();
       set = new HashSet();

/*
        for(int j=1;j<=s.length();j++){//寻找所有可能的头
            ArrayList<String> oneAns = new ArrayList<>();
            String head = s.substring(0,j);
            if(tree.isWord(head)){
                oneAns.add(head);
                boolean canFind =  find(s.substring(j),oneAns );
                oneAns.remove(head);
            }

        }
        */
        find(s,new ArrayList<String>());
        System.out.println(set.size());
        return res;
    }
    public boolean find(String curStr, ArrayList<String> oneAns){
        if(curStr == null || curStr.equals("")|| curStr==""){
            String oneAnsStr = "";
            for(int i=0;i<oneAns.size();i++){
                oneAnsStr += oneAns.get(i);
                if(i!=oneAns.size()-1) oneAnsStr+=" ";
            }
            res.add(oneAnsStr);
            set.add(oneAnsStr);
            return true;
        }

        boolean ans = false;
        for(int j=1;j<=curStr.length();j++){//j枚举的是右端点，所以是<=
            if(tree.isWord( curStr.substring(0,j))){
                String head = curStr.substring(0,j);
                oneAns.add(head);
                boolean subRes =  find(curStr.substring(j),oneAns);
                if(subRes){
                    ans =  ans||subRes;//不能一找到就回，可能还有其他解
                    //continue;//这个continue ， 导致一条‘全部’成功拆分的路径没有回溯
                }
//                oneAns.remove(head);
                oneAns.remove(oneAns.size()-1);
            }
        }
        return ans;
    }

}


//定义字典树节点
class Trie{
    Trie[] sub;
    int preFixCou;
    int wordCou;
    boolean isEnd;
    public Trie(){
        sub = new Trie[26];
    }

    public void addWord(String word){
        Trie cur = this;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.sub[ch-'a']==null){
                cur.sub[ch-'a'] = new Trie();

            }
            cur = cur.sub[ch-'a'];
            cur.preFixCou++;
        }
        cur.wordCou++;
        cur.isEnd = true;
    }
    public boolean isPrefix(String word){
        Trie cur = this;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.sub[ch-'a']== null) return false;
            cur = cur.sub[ch-'a'];
        }
        return true;
    }
    public boolean isWord(String word){
        Trie cur = this;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.sub[ch-'a']== null) return false;
            cur = cur.sub[ch-'a'];
        }
        if(cur.isEnd) return true;
        return false;

    }
}
