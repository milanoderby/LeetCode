class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> prefixNumberCountMap = new HashMap<>();
        Map<Integer, Integer> suffixNumberCountMap = new HashMap<>();

        for (int i = 0; i <= 0; i++) {
            int num = nums[i];
            int count = prefixNumberCountMap.getOrDefault(num, 0);
            prefixNumberCountMap.put(num, count + 1);
        }

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int count = suffixNumberCountMap.getOrDefault(num, 0);
            suffixNumberCountMap.put(num, count + 1);
        }

        int[] answer = new int[nums.length];
        answer[0] = prefixNumberCountMap.size() - suffixNumberCountMap.size();

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int count = prefixNumberCountMap.getOrDefault(num, 0);
            prefixNumberCountMap.put(num, count + 1);

            count = suffixNumberCountMap.get(num);
            count--;
            if (count == 0) {
                suffixNumberCountMap.remove(num);
            } else {
                suffixNumberCountMap.put(num, count);
            }

            answer[i] = prefixNumberCountMap.size() - suffixNumberCountMap.size();
        }
        return answer;
    }
}