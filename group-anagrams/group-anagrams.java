class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        Map<String, Integer> anagramIndexMap = new HashMap<>();
        for (String str : strs) {
            String sortedString = sortStringByCharacter(str);
            if (anagramIndexMap.containsKey(sortedString)) {
                int index = anagramIndexMap.get(sortedString);
                answer.get(index).add(str);
            } else {
                anagramIndexMap.put(sortedString, answer.size());
                answer.add(new ArrayList<>(Arrays.asList(str)));
            }
        }

        return answer;
    }
    
    private static String sortStringByCharacter(String str) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }
        Collections.sort(characters);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characters) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}