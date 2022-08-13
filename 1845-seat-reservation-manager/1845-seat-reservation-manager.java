class SeatManager {

    private PriorityQueue<Integer> unreservedSeat;
        public SeatManager(int n) {
            unreservedSeat = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                unreservedSeat.add(i);
            }
        }

        public int reserve() {
            return unreservedSeat.poll();
        }

        public void unreserve(int seatNumber) {
            unreservedSeat.add(seatNumber);
        }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */