class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> resultSet = new HashSet<>();
        long longTarget = (long)target;

        // 200 * 200 * 200 = 8 * 10^6
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                long tmp = longTarget - (long)(nums[i] + nums[j]);
                int leftIdx = j + 1;
                int rightIdx = n - 1;
                while (leftIdx < rightIdx) {
                    int leftNum = nums[leftIdx];
                    int rightNum = nums[rightIdx];
                    long check = tmp - (long)(leftNum + rightNum);
                    if (check == 0) {
                        List<Integer> nextAdd = List.of(nums[i], nums[j], leftNum, rightNum);
                        resultSet.add(nextAdd);
                        leftIdx += 1;
                        rightIdx -= 1;
                    } else if (check > 0) {
                        leftIdx += 1;
                    } else {
                        rightIdx -= 1;
                    }
                }
            }
        }

        for (List<Integer> list: resultSet) {
            result.add(list);
        }

        return result;
    }
}