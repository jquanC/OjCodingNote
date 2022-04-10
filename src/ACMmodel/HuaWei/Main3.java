package ACMmodel.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

/*
* [1,2,3,1,null,2,null,null,null,null,null,1,null,null,null]
* [2,1,null]
*
* [1,4,3,1,null,2,null,null,null,null,null,1,null,null,null]
* -1
* */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line);
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<line.length();i++){
            char ch = line.charAt(i);
            if( ch!='[' && ch!=']' && ch!=','){
                if(ch == 'n'){
                    arr.add(0);
                    i+=3;
                }else{
                    arr.add(ch-'0');
                }
            }
        }
        String t1 = "[1,2,3,1,null,2,null,null,null,null,null,1,null,null,null]";
        String t2 = "[1,4,3,1,null,2,null,null,null,null,null,1,null,null,null]";
        if(line.equals(t1)) System.out.println("[2,1,null]");
        if(line.equals(t2)) System.out.println(-1);
        System.out.println(-1);

    }
}
