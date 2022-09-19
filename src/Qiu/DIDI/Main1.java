package Qiu.DIDI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] crr = line.toCharArray();
        int[] arr = new int[crr.length];
        for (int i = 0; i < crr.length; i++) {
            if (crr[i] != '?') arr[i] = crr[i] - '0';
            else arr[i] = -0x3f3f3f;
        }
        ArrayList<Integer> quesLocation = new ArrayList();
        int originSum = 0;
        for (int i = 0; i < crr.length; i++) {
            if (crr[i] == '?') {
                quesLocation.add(i);
            } else {
                originSum += crr[i] - '0';
            }
        }
        //从左往右先贪心的把每个位置填为左右不冲突的最小值
        int addSum = 0;
        for (int i = 0; i < quesLocation.size(); i++) {
            int idx = quesLocation.get(i);
            for (int j = 0; j <= 9; j++) {
                if (idx == 0 && j == 0) continue;//最高位跳过，从j=1开始考虑
                //首尾两种情况，首
                if (idx == 0 && j != 0) {
                    if (crr[idx + 1] == '?' || arr[idx + 1] != j) {
//                         crr[idx] = (char)('0'+j);
                        arr[idx] = j;
                        addSum += j;
                        break;
                    }
                } else if (idx == crr.length - 1) {//尾
                    if (crr[idx - 1] == '?' || arr[idx - 1] != j) {
//                        crr[idx] = (char)('0'+j);
                        arr[idx] = j;
                        addSum += j;
                        break;
                    }
                } else {
                    //中间普通情况
                    if ((crr[idx - 1] == '?' || arr[idx - 1] != j) && (crr[idx + 1] == '?' || arr[idx + 1] != j)) {
//                    crr[idx] = (char)('0'+j);
                        arr[idx] = j;
                        addSum += j;
                        break;
                    }
                }

            }
        }
        //调整为3的倍数
        boolean finish = false;
        if ((originSum + addSum) % 3 == 0) {
//            String ansStr = String.valueOf(crr);
//            Integer ans = Integer.valueOf(ansStr);
//            System.out.println(ans);
            finish = true;
        }
        int curSum = originSum + addSum;
        //从低位问号出数字开始处理
//        boolean finish = false;
        for (int i = quesLocation.size() - 1; i >= 0 && !finish; i--) {
            int idx = quesLocation.get(i);

            int idxOldVal = arr[idx];
            for (int j = idxOldVal + 1; j <= 9; j++) {
                if (idx == arr.length - 1) {
                    if (arr[idx - 1] != j) {
                        arr[idx] = j;
                    }
                } else if (idx == 0) {
                    if (arr[idx + 1] != j) {
                        arr[idx] = j;
                    }
                } else {
                    if (arr[idx - 1] != j && arr[idx + 1] != j) {
                        arr[idx] = j;
                    }
                }

                if ((curSum + arr[idx] - idxOldVal) % 3 == 0) {
                    finish = true;
                    break;
                }
            }
            curSum += arr[idx] - idxOldVal;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum *= 10;
            sum += arr[i];
        }
        System.out.println(sum);

    }
}

