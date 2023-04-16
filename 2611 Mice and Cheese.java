class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        List<RewardDiff> rewardDiffList = new ArrayList<>();
        for (int i = 0; i < reward1.length; i++) {
            rewardDiffList.add(new RewardDiff(i, reward1[i] - reward2[i]));
        }

        Collections.sort(rewardDiffList, Comparator.comparingInt(RewardDiff::getDiff).reversed());

        int answer = 0;
        for (int i = 0; i < k; i++) {
            int index1 = rewardDiffList.get(i).index;
            answer += reward1[index1];
        }

        for (int i = k; i < rewardDiffList.size(); i++) {
            int index2 = rewardDiffList.get(i).index;
            answer += reward2[index2];
        }
        return answer;
    }
    
    private static class RewardDiff {
        private int index;
        private int diff;

        public RewardDiff(int index, int diff) {
            this.index = index;
            this.diff = diff;
        }

        public int getDiff() {
            return diff;
        }
    }
}