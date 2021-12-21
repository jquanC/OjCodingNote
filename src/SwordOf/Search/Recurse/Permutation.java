package SwordOf.Search.Recurse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public String[] permutation(String s) {
        char[] chArr = s.toCharArray();
        List<String> res = new ArrayList<>();
        Arrays.sort(chArr);
        res.add(String.valueOf(chArr));
        while (nextPermutation(chArr)) {
            res.add(String.valueOf(chArr));
        }
        return res.toArray(new String[res.size()]);
    }

    boolean nextPermutation(char[] arr) {
        boolean findRes = false;
        //找a[i]
        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] < arr[i + 1]) {
                findRes = true;
                break;
            }
            i--;
        }
        if (findRes) {
            int j = arr.length - 1;
            //上面保证了这里至少能找到一个j
            while (j > i) {
                if (arr[j] > arr[i]) break;
                j--;
            }
            swap(arr, i, j);
            //将a[i+1],...,a[len-1]这一段重排是升序。由于当前状态是降序，直接做交换可以在O(n)时间内完成
            reverse(arr, i + 1, arr.length - 1);
        }
        return findRes;
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (end > start) {
            swap(arr, start, end);
            start ++;
            end --;
        }
    }
    @Test
    public void test(){
        String s = "mdpesmo";
        String [] res = permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
