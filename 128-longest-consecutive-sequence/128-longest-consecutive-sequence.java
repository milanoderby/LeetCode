class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int countOfMaxConsecutiveElements = 0;
        for (int num : nums) {
            if (numSet.contains(num)) {
                countOfMaxConsecutiveElements = Math.max(countOfMaxConsecutiveElements, getCountOfConsecutiveElements(num, numSet));
            }
        }

        return countOfMaxConsecutiveElements;
    }
    
    public static int getCountOfConsecutiveElements(int num, Set<Integer> numSet) {
        numSet.remove(num);
        int count = 1;

        for (int temp = num + 1; numSet.contains(temp); temp++) {
            numSet.remove(temp);
            count++;
        }

        for (int temp = num - 1; numSet.contains(temp); temp--) {
            numSet.remove(temp);
            count++;
        }

        return count;
    }
}