package Hot100.Medium;

public class productExceptSelfSo {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) answer[i] = 1;
            else {
                answer[i] = answer[i - 1] * nums[i - 1];
            }
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) R = 1;
            else {
                R = R * nums[i + 1];
            }
            answer[i] = answer[i] * R;

        }
        return answer;
    }
}
