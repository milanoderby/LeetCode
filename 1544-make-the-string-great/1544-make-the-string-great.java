class Solution {
    public String makeGood(String s) {
        StringBuilder answer = new StringBuilder(s);
        for (int index = 0; index + 1 < answer.length(); ) {
            char current = answer.charAt(index);
            char next = answer.charAt(index + 1);
            if (Character.isLowerCase(current) ^ Character.isLowerCase(next)) {
                if (Character.toLowerCase(current) == Character.toLowerCase(next)) {
                    answer.delete(index, index + 2);
                    index = Math.max(index - 1, 0);
                    continue;
                }
            }
            index++;
        }

        return answer.toString();
    }
}