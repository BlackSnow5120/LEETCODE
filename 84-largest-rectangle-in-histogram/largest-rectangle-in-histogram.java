class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
               

                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
        }
        while (!stack.isEmpty()) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? n : n - stack.peek() - 1;
            

                    maxArea = Math.max(maxArea, h * w);
                }

        return maxArea;
    }
}
