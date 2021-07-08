class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int leftMaxHeight = 0;
        List<Line> leftLine = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) {
                continue;
            }

            if (leftMaxHeight < height[i]) {
                leftMaxHeight = height[i];
                leftLine.add(new Line(i, leftMaxHeight));
                continue;
            }

            int leftIndex = getMinIndex(leftLine, height[i]);
            maxArea = Math.max(maxArea, (i - leftIndex) * height[i]);
        }

        int rightMaxHeight = 0;
        List<Line> rightLine = new ArrayList<>();
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] == 0) {
                continue;
            }

            if (rightMaxHeight < height[i]) {
                rightMaxHeight = height[i];
                rightLine.add(new Line(i, rightMaxHeight));
                continue;
            }

            int rightIndex = getMinIndex(rightLine, height[i]);
            maxArea = Math.max(maxArea, (rightIndex - i) * height[i]);
        }

        return maxArea;
    }
    
    private static class Line {
        private int index;
        private int height;

        public Line(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    private static int getMinIndex(List<Line> lineList, int height) {
        // lineList에 있는 line들 중
        // 인자로 들어온 높이 값보다 높거나 같으면서, 가장 작은 index 값을 반환

        int start = 0;
        int end = lineList.size() - 1;

        if (lineList.get(start).height >= height) {
            return lineList.get(start).index;
        }

        int mid = (start + end) / 2;
        while (start + 1 < end) {
            if (lineList.get(mid).height >= height) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }
        return lineList.get(end).index;
    }
}