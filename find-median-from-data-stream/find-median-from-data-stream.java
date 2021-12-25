class MedianFinder {
    private PriorityQueue<Integer> bigNumberPQ;
    private PriorityQueue<Integer> smallNumberPQ;
    
    public MedianFinder() {
            bigNumberPQ = new PriorityQueue<>();
            smallNumberPQ = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (smallNumberPQ.isEmpty() && bigNumberPQ.isEmpty()) {
                smallNumberPQ.add(num);
                return;
            }

            if (smallNumberPQ.size() <= bigNumberPQ.size()) {
                int bigMiddle = bigNumberPQ.peek();
                if (num <= bigMiddle) {
                    smallNumberPQ.add(num);
                } else {
                    smallNumberPQ.add(bigNumberPQ.poll());
                    bigNumberPQ.add(num);
                }
            } else {
                int smallMiddle = smallNumberPQ.peek();
                if (num >= smallMiddle) {
                    bigNumberPQ.add(num);
                } else {
                    bigNumberPQ.add(smallNumberPQ.poll());
                    smallNumberPQ.add(num);
                }
            }
        }

        public double findMedian() {
            if (bigNumberPQ.size() == smallNumberPQ.size()) {
                return (smallNumberPQ.peek() + bigNumberPQ.peek()) / 2.0;
            } else {
                return smallNumberPQ.peek();
            }
        }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */