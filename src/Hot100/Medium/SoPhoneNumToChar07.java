package Hot100.Medium;

import java.util.*;

//转换表用HashMap结构，键是Character,值是列表
//对于输入digits,查表，将其号码对应字母添加到一个List中；对这个list，列举其组合数
//note
//用 Map<Character, String> phoneMap = new HashMap<Character, String>() {{...不是更香吗？初始化更简单put('2', "abc");...
//既然已经使用了Map数据结构，就不用再搞个 List<List<Character>> selectButton = new ArrayList<>(); 存储了
public class SoPhoneNumToChar07 {
    public List<String> letterCombinations(String digits) {
        if(Objects.equals(digits,"")){
            List<String> ans = new ArrayList<>();
            return ans;
        }

        Map<Character,List<Character>> table = new HashMap(8);

        List<Character> num2 = new ArrayList<>();
        num2.add('a');
        num2.add('b');
        num2.add('c');
        table.put('2',num2);

        List<Character> num3 = new ArrayList<>();
        num3.add('d');
        num3.add('e');
        num3.add('f');
        table.put('3',num3);

        List<Character> num4 = new ArrayList<>();
        num4.add('g');
        num4.add('h');
        num4.add('i');
        table.put('4',num4);

        List<Character> num5 = new ArrayList<>();
        num5.add('j');
        num5.add('k');
        num5.add('l');
        table.put('5',num5);

        List<Character> num6 = new ArrayList<>();
        num6.add('m');
        num6.add('n');
        num6.add('o');
        table.put('6',num6);

        List<Character> num7 = new ArrayList<>();
        num7.add('p');
        num7.add('q');
        num7.add('r');
        num7.add('s');
        table.put('7',num7);

        List<Character> num8 = new ArrayList<>();
        num8.add('t');
        num8.add('u');
        num8.add('v');
        table.put('8',num8);

        List<Character> num9 = new ArrayList<>();
        num9.add('w');
        num9.add('x');
        num9.add('y');
        num9.add('z');
        table.put('9',num9);

        //获取每次按键选择的字符列表
        List<List<Character>> selectButton = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            char c = digits.charAt(i);
            List<Character> temp = table.get(c);
            selectButton.add(temp);
        }

        //输出组合数;遍历每个元素一次，在这个过程保留所有组合的结果
        //递归，深度优先遍历
        /*List<String> ans = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        for (List<Character> e:selectButton) {
            selectButton.add(e
            for(Character c : e){

            }
        }*/
        int deep = selectButton.size();
        List<String> ans = new ArrayList<>();
        StringBuilder strBd = new StringBuilder();
        getAns(selectButton,0,deep-1,strBd,ans);
        return ans;

    }
    private void getAns(List<List<Character>> selectButton,int step,int deep,StringBuilder strBd,List<String> ans){
        if(step>deep){
            ans.add(strBd.toString());

            return;
        }
        List<Character> thisL = new ArrayList<>();
        thisL = selectButton.get(step);

        for (Character c: thisL
             ) {
            strBd.append(c);
            getAns(selectButton,step+1,deep,strBd,ans);
            strBd.deleteCharAt(step);//回溯
        }

    }
}
