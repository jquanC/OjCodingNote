package ACMmodel.ByteDance.re;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.*;

class word {
    public String str;
    public int cou;

    public word(String str, int cou) {
        this.str = str;
        this.cou = cou;
    }
}

public class NGram {
    static HashMap<String, ArrayList<word>> wordListMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String lines[] = line.split(" ");
            String key = "";
            for (int j = 0; j < lines.length - 1; j++) {
                key += lines[j];
                addTurple(key, lines[j + 1]);
            }
        }
        for (int i = 0; i < m; i++) {
            String queLine = sc.nextLine();
            String[] queLines = queLine.split(" ");
            String que = "";
            for(String e:queLines){
                que+=e;
            }
            List<String> ans = queryTopk(que, k);
            System.out.println(ans);
        }


    }

    public static void addTurple(String prefix, String nextWord) {
        if (!wordListMap.containsKey(prefix)) {
            ArrayList<word> list = new ArrayList<>();
            list.add(new word(nextWord, 1));
            wordListMap.put(prefix, list);
            return;
        }
        ArrayList<word> list = wordListMap.get(prefix);
        for (word e : list) {
            if (e.str.equals(nextWord)) {
                e.cou++;
                return;
            }
        }
        list.add(new word(nextWord, 1));

    }

    public static List<String> queryTopk(String key, int k) {
        ArrayList<word> list = wordListMap.get(key);
        if (list == null) return null;
        Comparator<word> com = new Comparator<word>() {
            @Override
            public int compare(word o1, word o2) {
                return o2.cou - o1.cou;
            }
        };
        list.sort(com);
        int t = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list.size() && t < k; i++) {
            ans.add(list.get(i).str);
            t++;
        }
        return ans;

    }

}
