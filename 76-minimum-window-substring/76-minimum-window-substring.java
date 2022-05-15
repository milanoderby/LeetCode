class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countOfCharacterInStringT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int countOfCharacter = countOfCharacterInStringT.getOrDefault(ch, 0).intValue();
            countOfCharacterInStringT.put(ch, countOfCharacter + 1);
        }

        Map<Character, Integer> countOfCharacterInStringS = new HashMap<>();
        ArrayDeque<CharacterIndex> characterIndexQueue = new ArrayDeque<>();
        String answer = "";
        int formed = 0;
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (!countOfCharacterInStringT.containsKey(ch)) {
                continue;
            }
            int countOfCharacter = countOfCharacterInStringS.getOrDefault(ch, 0).intValue();
            characterIndexQueue.add(new CharacterIndex(ch, index));
            countOfCharacterInStringS.put(ch, countOfCharacter + 1);
            if (countOfCharacterInStringS.get(ch).intValue() == countOfCharacterInStringT.get(
                ch).intValue()) {
                formed++;
            }

            if (formed == countOfCharacterInStringT.size()) {
                while (!characterIndexQueue.isEmpty()) {
                    CharacterIndex firstCharacter = characterIndexQueue.peekFirst();
                    if (countOfCharacterInStringS.get(firstCharacter.ch).intValue()
                        > countOfCharacterInStringT.get(firstCharacter.ch).intValue()) {
                        characterIndexQueue.pollFirst();
                        int countToUpdate = countOfCharacterInStringS.get(
                            firstCharacter.ch).intValue();
                        countOfCharacterInStringS.put(firstCharacter.ch, countToUpdate - 1);
                    } else {
                        break;
                    }
                }

                CharacterIndex firstCharacter = characterIndexQueue.peekFirst();
                CharacterIndex lastCharacter = characterIndexQueue.peekLast();
                String possibleAnswer = s.substring(firstCharacter.index, lastCharacter.index + 1);

                if (answer.equals("") || answer.length() > possibleAnswer.length()) {
                    answer = possibleAnswer;
                }
            }
        }

        return answer;
    }
    
    private static class CharacterIndex {

        private char ch;
        private int index;

        public CharacterIndex(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
}