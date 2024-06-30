class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        for(int num : nums) {
            int countOfNumber = numberCountMap.getOrDefault(num, 0);
            numberCountMap.put(num, countOfNumber + 1);
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        List<Integer> sortedSet = new ArrayList<>(numSet);
        Collections.sort(sortedSet);
        Queue<Integer> smallNumberQueue = new ArrayDeque<>(sortedSet);

        while(!smallNumberQueue.isEmpty()) {
            int smallest = smallNumberQueue.peek();
            if (numberCountMap.get(smallest) <= 0) {
                smallNumberQueue.poll();
                continue;
            }

            for(int i = 0; i < k; i++) {
                int current = smallest + i;
                int countOfCurrentNumber = numberCountMap.getOrDefault(current , 0);
                if(countOfCurrentNumber <= 0) {
                    return false;
                }

                countOfCurrentNumber--;
                numberCountMap.put(current, countOfCurrentNumber);
            }
        }

        return true;
    }
}