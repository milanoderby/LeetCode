class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> answer = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int addResult = (digits[i] + carry) % 10;
            answer.add(addResult);

            carry = (digits[i] + carry) / 10;
        }

        if (carry == 1) {
            answer.add(carry);
        }

        Collections.reverse(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}