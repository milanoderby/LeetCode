class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countOfMagazineChar = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int ch = magazine.charAt(i) - 'a';
            countOfMagazineChar[ch]++;
        }

        int[] countOfRansomNoteChar = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int ch = ransomNote.charAt(i) - 'a';
            countOfRansomNoteChar[ch]++;
            if (countOfRansomNoteChar[ch] > countOfMagazineChar[ch]) {
                return false;
            }
        }
        return true;
    }
}