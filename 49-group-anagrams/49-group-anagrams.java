class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String originalString : strs) {
            char[] chars = originalString.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            List<String> anagramList = anagramMap.getOrDefault(sortedString, new ArrayList<>());
            anagramList.add(originalString);
            anagramMap.put(sortedString, anagramList);
        }

        return anagramMap.values().stream().collect(Collectors.toList());
    }
}