class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        var idx = 0;
        var result = 0;
        while (arr.length > idx) {
            var startIdx = idx;
            var localResult = 0;
            var currChar = arr[idx];
            HashSet<Character> set = new HashSet<>();

            while (!set.contains(currChar)) {
                set.add(currChar);
                localResult += 1;
                idx += 1;
                if (idx >= arr.length) {
                    break;
                }
                currChar = arr[idx];
            }
            result = Math.max(result, localResult);

            if (localResult > 1) {
                idx = startIdx + 1;
            }
        }
        return result;
    }
}