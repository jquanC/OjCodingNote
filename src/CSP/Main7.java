package CSP;



import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        Pair resident = new Pair();
        n=scanner.nextInt();
        resident.x = scanner.nextInt();
        resident.y = scanner.nextInt();
        Pair[] locationArr = new Pair[n];


        for(int i=0;i<n;i++){
            locationArr[i] = new Pair();
            locationArr[i].x = scanner.nextInt();
            locationArr[i].y = scanner.nextInt();
            locationArr[i].dis = calDistance(locationArr[i].x,locationArr[i].y,resident);
            locationArr[i].number = i+1;
        }
        Arrays.sort(locationArr,(a,b)->a.dis-b.dis);
        System.out.println(locationArr[0].number);
        System.out.println(locationArr[1].number);
        System.out.println(locationArr[2].number);




    }
    private static int calDistance(int x ,int y,Pair resident){
        return  (resident.x-x)*(resident.x-x)+(resident.y-y)*(resident.y-y);
    }

}
class Pair{
    public int x;
    public int y;
    public int number;
    public int dis;

}
