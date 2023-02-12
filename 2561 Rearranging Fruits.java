class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> numberOfBasket1 = new HashMap<>();
        Map<Integer, Integer> numberOfBasket2 = new HashMap<>();
        Map<Integer, Integer> numberOfAllBaskets = new HashMap<>();

        for (int number : basket1) {
            numberOfBasket1.compute(number, (key, value) -> value == null ? 1 : value + 1);
            numberOfAllBaskets.compute(number, (key, value) -> value == null ? 1 : value + 1);
        }

        for (int number : basket2) {
            numberOfBasket2.compute(number, (key, value) -> value == null ? 1 : value + 1);
            numberOfAllBaskets.compute(number, (key, value) -> value == null ? 1 : value + 1);
        }


        for (Integer value : numberOfAllBaskets.values()) {
            if (value % 2 == 1) {
                return -1;
            }
        }

        int minNumber = Integer.MAX_VALUE;
        int countToChange = 0;
        List<NumberToChange> numberToChangeList = new ArrayList<>();
        for (Integer key : numberOfAllBaskets.keySet()) {
            minNumber = Math.min(minNumber, key);

            int count1 = numberOfBasket1.getOrDefault(key, 0);
            int count2 = numberOfBasket2.getOrDefault(key, 0);

            if (count1 == count2) {
                continue;
            }

            countToChange += Math.abs(count1 - count2) / 2;
            numberToChangeList.add(new NumberToChange(key, Math.abs(count1 - count2) / 2));
        }
        countToChange /= 2;

        long answer = 0;
        Collections.sort(numberToChangeList, Comparator.comparingInt(NumberToChange::getNumber));
        for (NumberToChange numberToChange : numberToChangeList) {
            if (2 * minNumber < numberToChange.number) {
                answer += 2L * minNumber * countToChange;
                break;
            }

            if (numberToChange.count <= countToChange) {
                answer += (long) numberToChange.number * numberToChange.count;
                countToChange -= numberToChange.count;
            } else {
                answer += (long) numberToChange.number * countToChange;
                break;
            }
        }

        return answer;
    }
    
    private static class NumberToChange {
        private int number;
        private int count;

        public NumberToChange(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }
    }
}