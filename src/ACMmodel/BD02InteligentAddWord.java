package ACMmodel;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BD02InteligentAddWord {
    public static void main(String[] args){
        int n,m,k;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        in.nextLine();
        HashMap<String,HashMap<String,Integer>> tupleMap = new HashMap<>();

        for(int i=0;i<n;i++){
            String curLine = in.nextLine();
            String[] curStr = curLine.split(" ");
            String prefix ="";
            for(int j=0;j<curStr.length-1;j++){
                prefix += curStr[j];
                String nextWord = curStr[j+1];
                HashMap<String,Integer> nextWordList = tupleMap.getOrDefault(prefix,new HashMap<String,Integer>());
                nextWordList.put(nextWord,nextWordList.getOrDefault(nextWord,0)+1);
                tupleMap.put(prefix,nextWordList);
            }
        }
        for(int i=0;i<m;i++){
            String prefix = in.nextLine();
            System.out.println("search prefix: "+prefix);//得去空格才是标准的prefix
            String standardPrefix = "";
            String[] temp = prefix.split(" ");
            for(String e:temp){
                standardPrefix+=e;
            }
            HashMap<String,Integer> storeNextWordList = tupleMap.getOrDefault(standardPrefix,null);
            if(storeNextWordList == null) System.out.println("error");

            NextWord[] words = new NextWord[storeNextWordList.size()];
            int j =0;
            for(String e:storeNextWordList.keySet()){
                int cou = storeNextWordList.get(e);
                words[j++] = new NextWord(e,cou);
            }
            Arrays.sort(words,(a,b)->a.count-b.count);
            for(int t=0;t<k;t++){
                System.out.println(words[t].nextWord);
            }


        }

    }
    static class NextWord{
        String nextWord;
        int count;
        public  NextWord(String nextWord,int count){
            this.nextWord = nextWord;
            this.count = count;
        }
    }


}
