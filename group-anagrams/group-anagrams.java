class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] countOfChar = new char[26];
            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i) - 'a';
                countOfChar[ch]++;
            }

            String anagramKey = new String(countOfChar);
            List<String> anagramList = anagramMap.getOrDefault(anagramKey, new ArrayList<>());
            anagramList.add(str);
            anagramMap.put(anagramKey, anagramList);
        }

        return new ArrayList<>(anagramMap.values());
    }
}