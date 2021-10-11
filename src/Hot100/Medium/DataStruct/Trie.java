package Hot100.Medium.DataStruct;

import java.security.cert.TrustAnchor;

public class Trie {

    Trie[] children = new Trie[26];
    boolean isEnd;
    int count; //以当前单词结尾的 单词数量
    int numPrefix;//以该结点之前的字符串为前缀的单词的数量

    public Trie(){
        count = 0;
        numPrefix =0 ;
    }

    /**
     *
     * */
    public void insert(String word){
        if(word ==null || word.length()==0) return;
        Trie node = this;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch-'a';
            if(node.children[index]==null){
                node.children[index] = new Trie();

            }
            node = node.children[index];
            node.numPrefix++; //位置
        }
        node.isEnd = true;
        node.count++;//位置

    }
    public boolean search(String word){
        Trie node = searchPrefix(word);
        return node!=null && node.isEnd;
    }
    public boolean startsWith(String prefix){
        return  searchPrefix(prefix)!=null;
    }
    public Trie searchPrefix(String prefix){
        Trie node = this;
        for(int i =0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            int index = ch-'a';
            if(node.children[index]==null){
                return null;
            }else{
                node = node.children[index];
            }
        }
        return node;
    }

}
