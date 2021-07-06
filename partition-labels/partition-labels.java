class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int[] firstAppear = new int[26];
        for (int i = 0; i < 26; i++) {
            firstAppear[i] = -1;
        }
        int[] lastAppear = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int vowel = s.charAt(i) - 'a';
            if (firstAppear[vowel] == -1) {
                firstAppear[vowel] = i;
            }
            lastAppear[vowel] = i;
        }

        int startOfPartition = 0;
        int vowel = s.charAt(0) - 'a';
        int endOfPartition = lastAppear[vowel];

        for (int i = 0; i < s.length(); i++) {
            if (i == endOfPartition) {
                answer.add(endOfPartition - startOfPartition + 1);

                if (i + 1 >= s.length()) {
                    break;
                }
                startOfPartition = i + 1;
                vowel = s.charAt(i + 1) - 'a';
                endOfPartition = lastAppear[vowel];
            } else {
                vowel = s.charAt(i) - 'a';
                if (endOfPartition < lastAppear[vowel]) {
                    endOfPartition = lastAppear[vowel];
                }
            }
        }
        return answer;
    }
}