class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] countOfChar = new char[26];
            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i) - 'a';
                countOfChar[ch]++;
            }

            StringBuilder anagramBuilder = new StringBuilder();
            for (int i = 0; i < countOfChar.length; i++) {
                if (countOfChar[i] > 0) {
                    anagramBuilder.append((char) ('a' + i));
                    anagramBuilder.append(countOfChar[i]);
                }
            }

            String anagram = anagramBuilder.toString();
            List<String> anagramList = anagramMap.getOrDefault(anagram, new ArrayList<>());
            anagramList.add(str);
            anagramMap.put(anagram, anagramList);
        }

        return new ArrayList<>(anagramMap.values());
    }
}