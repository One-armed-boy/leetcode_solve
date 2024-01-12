class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int result = 0;
        
        int subArrLen = 0;
        
        boolean isUp = false;
        boolean isPostFlat = true;
        
        for (int idx = 0; idx < arr.length -1; idx++) {
            int cur = arr[idx];
            int next = arr[idx + 1];
            
            if (cur < next) {
                // 오르막 등장
                if (!isUp) {
                    result = Math.max(result, isPostFlat ? 0 : subArrLen);
                    subArrLen = 1;
                }
                isUp = true;
                isPostFlat = false;
                subArrLen++;
            } else if (cur > next) {
                // 내리막 등장
                isUp = false;
                if (isPostFlat) {
                    continue;
                }
                subArrLen++;
            } else {
                // 평지인 경우 -> 초기화
                if (!isUp && !isPostFlat) {
                    result = Math.max(result, subArrLen);
                }
                isUp = false;
                isPostFlat = true;
                subArrLen = 0;
            }
        }
        
        // 최종까지 세다가 오르막을 만나지 못한 경우의 수 포함
        return Math.max(result, isUp ? 0 : subArrLen);
    }
}