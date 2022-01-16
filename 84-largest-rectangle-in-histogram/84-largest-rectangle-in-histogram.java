class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Bar> barStack = new Stack<>();
        barStack.add(new Bar(0, heights[0]));
        int[] leftWidth = new int[heights.length];
        leftWidth[0] = 1;
        for (int index = 1; index < heights.length; index++) {
            while (!barStack.isEmpty()) {
                Bar leftBar = barStack.peek();
                // 현재 index에서 왼쪽으로 뻗을 수 있는 길이
                // 왼쪽의 높이가 현재 index의 높이보다 낮을 경우, 왼쪽으로 뻗을 수 없음
                // 계속해서 왼쪽으로 뻗을 수 없으므로 Stack에서 제거하지 않고, 냅둔다.
                if (leftBar.getHeight() < heights[index]) {
                    leftWidth[index] = index - leftBar.getIndex();
                    barStack.add(new Bar(index, heights[index]));
                    break;
                }
                // 왼쪽의 높이가 현재 index의 높이보다 높거나 같을 경우, 왼쪽으로 뻗을 수 있음
                // 계속해서 왼쪽으로 뻗을 수 있으므로 Stack에서 제거한다.
                else {
                    barStack.pop();
                }
            }

            if (barStack.isEmpty()) {
                leftWidth[index] = index + 1;
                barStack.add(new Bar(index, heights[index]));
            }
        }

        barStack = new Stack<>();
        barStack.add(new Bar(heights.length - 1, heights[heights.length - 1]));

        int[] rightWidth = new int[heights.length];
        rightWidth[0] = 1;
        for (int index = heights.length - 1; index >= 0; index--) {
            while (!barStack.isEmpty()) {
                Bar rightBar = barStack.peek();
                if (rightBar.getHeight() < heights[index]) {
                    rightWidth[index] = rightBar.getIndex() - index;
                    barStack.add(new Bar(index, heights[index]));
                    break;
                } else {
                    barStack.pop();
                }
            }

            if (barStack.isEmpty()) {
                rightWidth[index] = heights.length - index;
                barStack.add(new Bar(index, heights[index]));
            }
        }

        int maxAreaOfRectangle = 0;
        for (int index = 0; index < heights.length; index++) {
            int widthOfRectangle = leftWidth[index] + rightWidth[index] - 1;
            int heightOfRectangle = heights[index];
            maxAreaOfRectangle = Math.max(maxAreaOfRectangle, widthOfRectangle * heightOfRectangle);
        }
        return maxAreaOfRectangle;
    }
    
    private static class Bar {
        private int index;
        private int height;

        public Bar(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getIndex() {
            return index;
        }

        public int getHeight() {
            return height;
        }
    }
}