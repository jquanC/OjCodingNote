package ACMmodel.BaiDu;



import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    static int ans=0;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        count(line);
        System.out.println(ans);

    }
    public  static void  count(String line){
        int len = line.length();
        HashSet<String> curLenSet = new HashSet<>();
        for(int i=0;i<len-1;i++){
            char c1 = line.charAt(i);
            char c2 = line.charAt(i+1);
            if(c1==c2){
                /*String newLine;
                if(c1==0)  newLine = line.substring(c2,len);
                else newLine = line.substring(0,c1)+line.substring(c2,len);*/
                String newLine = line.substring(0,i)+line.substring(i+1,len);
                if(!set.contains(newLine)){
                    ans++;
                    ans = (int)(ans%(1e9+7));
                    set.add(newLine);
                    curLenSet.add(newLine);
                }
            }else{
                if(c1<c2){
                    String newLine = line.substring(0,i)+line.substring(i+1,len);
                    if(!set.contains(newLine)){
                        ans++;
                        ans = (int)(ans%(1e9+7));
                        set.add(newLine);
                        curLenSet.add(newLine);
                    }
                }else{
                    String newLine = line.substring(0,i)+line.substring(i+1,len);
                    if(!set.contains(newLine)){
                        ans++;
                        ans = (int)(ans%(1e9+7));
                        set.add(newLine);
                        curLenSet.add(newLine);
                    }
                }
            }
        }
        for(String e:curLenSet){
            count(e);
        }

    }
}
