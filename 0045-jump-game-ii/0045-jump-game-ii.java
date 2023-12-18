import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int jump(int[] nums) {
        int[] memoList = new int[nums.length];
        // Daniel's tip: Integer 최대 수 기억하기 어렵기 때문에 간단하게 1987654321로 초기화
        Arrays.fill(memoList, 1987654321);
        memoList[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxJumpLen = nums[i];
            for (int j = 1; i + j <= Math.min(nums.length - 1, i + maxJumpLen); j++) {
                memoList[i+j] = Math.min(memoList[i+j], memoList[i] + 1);
            }
        }
        return memoList[nums.length - 1];
    }
}