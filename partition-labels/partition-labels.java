class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int[] firstAppear = new int[26];
        for (int i = 0; i < 26; i++) {
            firstAppear[i] = -1;
        }
        int[] lastAppear = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int vowelIndex = s.charAt(i) - 'a';
            if (firstAppear[vowelIndex] == -1) {
                firstAppear[vowelIndex] = i;
            }
            lastAppear[vowelIndex] = i;
        }

        int startOfPartition = 0;
        int vowelIndex = s.charAt(0) - 'a';
        int endOfPartition = lastAppear[vowelIndex];

        for (int i = 0; i < s.length(); i++) {
            if (i == endOfPartition) {
                answer.add(endOfPartition - startOfPartition + 1);

                if (i + 1 >= s.length()) {
                    break;
                }
                startOfPartition = i + 1;
                vowelIndex = s.charAt(i + 1) - 'a';
                endOfPartition = lastAppear[vowelIndex];
            } else {
                vowelIndex = s.charAt(i) - 'a';
                if (endOfPartition < lastAppear[vowelIndex]) {
                    endOfPartition = lastAppear[vowelIndex];
                }
            }
        }
        return answer;
    }
}