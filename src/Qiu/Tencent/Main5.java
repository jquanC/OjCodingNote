package Qiu.Tencent;



import java.util.Scanner;

public class Main5 {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int[] dx = new int[]{1, -1, 1, -1};
    static int[] dy = new int[]{-1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        long xStart = sum / 2;
        while (xStart >= 0) {
            boolean ans = check(xStart, sum - xStart);
            if (ans) break;
            xStart--;
        }
        System.out.println(sb.toString());


    }

    public static boolean check(long x, long y) {
        boolean ans = false;
        for(int i=0;i<4;i++){
            x = x*dx[i];
            y = x*dy[i];

           ans = ans | addTry(x,y,0,0);
        }
        return ans;


    }
    public static boolean addTry(long x,long y,int step,long sum){
       boolean ans = false;
        if(step == nums.length ){
            if(sum ==0) return true;
            return false;
        }

        sb.append('X');
        ans |= addTry(x,y,step+1,sum+x*nums[step]);
        sb.deleteCharAt(sb.length()-1);
        sb.append('Y');
        ans |= addTry(x,y,step+1,sum+y*nums[step]);
        sb.deleteCharAt(sb.length()-1);
        return ans;

    }
}
