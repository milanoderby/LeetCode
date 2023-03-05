class Solution {
    public int[] divisibilityArray(String word, int m) {
        List<Integer> answer = new ArrayList<>();
        long number = 0;
        for (int i = 0; i < word.length(); i++) {
            number = (number % m) * (10 % m);
            number = (number % m) + ((word.charAt(i) - '0') % m);

            if (number % m == 0) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}