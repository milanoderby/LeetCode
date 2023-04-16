class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();

        int maxCount = 0;
        for (int num : nums) {
            int countOfNumber = numberCountMap.getOrDefault(num, 0);
            numberCountMap.put(num, countOfNumber + 1);

            maxCount = Math.max(maxCount, countOfNumber + 1);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            answer.add(new ArrayList<>());
        }

        for (Integer number : numberCountMap.keySet()) {
            int countOfNumber = numberCountMap.get(number);
            for (int i = 0; i < countOfNumber; i++) {
                answer.get(i).add(number);
            }
        }
        return answer;
    }
}