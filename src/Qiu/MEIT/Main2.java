package Qiu.MEIT;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            if (a + b < 3) System.out.println(0);
            else {
                int ans = cal(a, b);
                System.out.println(ans);
            }

        }
    }

    public static int cal(int aNum, int bNum) {
        if (aNum + bNum < 3) return 0;

        long maxBox = 0;
        long lNum = Math.min(aNum, bNum);
        long mNum = Math.max(aNum, bNum);

        long j = lNum;
        long adder = 0;
        for (long i = lNum; i >= 1 && j >= 1; i--) {
            if (j * 2 + adder <= mNum) {
                maxBox = i;
                break;
            }
            j -= 2;
            adder++;
        }
        return (int) maxBox;

    }
}
