import java.util.Stack;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        stack.push(newInterval);
        for (int idx = 0; idx < intervals.length; idx++) {
            int[] headOfStack = stack.pop();
            if (isOverlap(headOfStack, intervals[idx])) {
                int[] newHead = mergeArr(headOfStack, intervals[idx]);
                stack.push(newHead);
                continue;
            }
            
            if (headOfStack[0] < intervals[idx][0]) {
                stack.push(headOfStack);
                stack.push(intervals[idx]);   
            } else {
                stack.push(intervals[idx]);
                stack.push(headOfStack);
            }
        }
        
        return convertStackToArray(stack);
    }
    
    private boolean isOverlap(int[] arr1, int[] arr2) {
        int a1 = arr1[0];
        int a2 = arr1[1];
        int b1 = arr2[0];
        int b2 = arr2[1];
        return (a2>=b1 & b2>=a1);
    }
    
    private int[] mergeArr(int[] arr1, int[] arr2) {
        int a1 = arr1[0];
        int a2 = arr1[1];
        int b1 = arr2[0];
        int b2 = arr2[1];
        int[] arr = new int[2];
        arr[0] = Math.min(a1,b1);
        arr[1] = Math.max(a2,b2);
        return arr;
    }
    
    private int[][] convertStackToArray(Stack<int[]> stack) {
        int len = stack.size();
        int[][] arr = new int[len][2];
        int idx = 0;
        while (!stack.empty()) {
            arr[len - idx - 1] = stack.pop();
            idx++;
        }
        return arr;
    }
}