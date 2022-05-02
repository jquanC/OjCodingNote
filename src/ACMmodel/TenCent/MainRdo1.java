package ACMmodel.TenCent;



import java.util.ArrayList;
import java.util.Scanner;
/*给n个数字字符串，每个字符串长度为m，然后从上到下对齐，从上到下构建数字，排序输出*/
public class MainRdo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strr = new String[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            strr[i] = sc.nextLine();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int j=0;j<strr[0].length();j++){
            int x=0;
            for(int i=0;i<n;i++){
                x*=10;
                x+=strr[i].charAt(j)-'0';
            }
            list.add(x);
        }
        list.sort((o1,o2)->{return o1-o2;});
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i!=list.size()-1) System.out.print(" ");
        }

    }

}
