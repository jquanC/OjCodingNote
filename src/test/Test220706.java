package test;

public class Test220706 {
    public static void main(String[] args) {
        int index = 0;
//        int seeIndex = dfs(index++);
        int seeIndex = dfs(++index);
        System.out.println("index:"+index);
        System.out.println("seenIndex"+seeIndex);

    }
    public static int dfs(int index){
        return index;
    }
}
