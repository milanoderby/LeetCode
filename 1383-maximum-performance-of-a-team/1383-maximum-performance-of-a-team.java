class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            engineerList.add(new Engineer(speed[i], efficiency[i]));
        }

        Collections.sort(engineerList, Comparator.comparingInt(Engineer::getEfficiency).reversed());

        PriorityQueue<Integer> minimumSpeedPQ = new PriorityQueue<>();
        long totalSpeed = 0;
        long bestPerformance = 0;

        for (Engineer engineer : engineerList) {
            if (minimumSpeedPQ.size() < k) {
                minimumSpeedPQ.add(engineer.getSpeed());
                totalSpeed += engineer.getSpeed();
            } else {
                minimumSpeedPQ.add(engineer.getSpeed());
                int decresedSpeed = minimumSpeedPQ.poll();
                totalSpeed += (engineer.getSpeed() - decresedSpeed);
            }
            bestPerformance = Math.max(bestPerformance, totalSpeed * engineer.getEfficiency());
        }
        return (int) (bestPerformance % 1000_000_007);
    }
    
    private static class Engineer {
        private int speed;
        private int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public int getSpeed() {
            return speed;
        }

        public int getEfficiency() {
            return efficiency;
        }
    }
}