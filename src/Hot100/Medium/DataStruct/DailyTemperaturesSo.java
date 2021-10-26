package Hot100.Medium.DataStruct;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperaturesSo {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int index = stack.peek();
                    if (temperatures[index] < temperatures[i]) {
                        res[index] = i - index;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(i);

            }
        }
        return res;

    }
}
