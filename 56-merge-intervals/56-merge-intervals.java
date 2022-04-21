class Solution {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], true));
            intervalList.add(new Interval(interval[1], false));
        }

        intervalList.sort(Comparator.comparingInt(Interval::getPoint).thenComparing(Interval::isStartPoint, Comparator.reverseOrder()));

        int countOfInterval = 0;

        int startPoint = 0;
        int endPoint = 0;

        List<int[]> answer = new ArrayList<>();
        for (Interval interval : intervalList) {
            if (interval.isStartPoint()) {
                countOfInterval++;
                if (countOfInterval == 1) {
                    startPoint = interval.getPoint();
                }
            } else {
                countOfInterval--;
                if (countOfInterval == 0) {
                    endPoint = interval.getPoint();
                    answer.add(new int[]{startPoint, endPoint});
                }
            }
        }

        return answer.toArray(new int[answer.size()][2]);
    }
    
    private static class Interval {
        private int point;
        private boolean isStartPoint;

        public Interval(int point, boolean isStartPoint) {
            this.point = point;
            this.isStartPoint = isStartPoint;
        }

        public int getPoint() {
            return point;
        }

        public boolean isStartPoint() {
            return isStartPoint;
        }
    }
}