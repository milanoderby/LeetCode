import java.util.Map.*;
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int key : nums) {
            if (!numMap.containsKey(key)) {
                numMap.put(key, 1);
            } else {
                int countOfNum = numMap.get(key);
                numMap.replace(key, countOfNum + 1);
            }
        }

        int max = 0;
        int majorityElement = 0;
        for (Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                majorityElement = entry.getKey();
            }
        }

        return majorityElement;
    }
}