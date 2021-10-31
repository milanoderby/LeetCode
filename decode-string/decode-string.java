class Solution {
    public String decodeString(String s) {
        StringBuilder answer = new StringBuilder();
        int repeatCount = 0;
        for (AtomicInteger index = new AtomicInteger(0); index.get() < s.length(); index.incrementAndGet()) {
            char ch = s.charAt(index.get());
            if ('0'<= ch && ch <= '9') {
                repeatCount *= 10;
                repeatCount += ch - '0';
            } else if (ch == '[') {
                index.incrementAndGet();
                answer.append(repeatString(s, index, repeatCount));
                repeatCount = 0;
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }
    
    private static StringBuilder repeatString(String s, AtomicInteger index, int count) {
        StringBuilder temp = new StringBuilder();
        int repeatCount = 0;
        for ( ; index.get() < s.length(); index.incrementAndGet()) {
            char ch = s.charAt(index.get());
            if ('0'<= ch && ch <= '9') {
                repeatCount *= 10;
                repeatCount += ch - '0';
            } else if (ch == '[') {
                index.incrementAndGet();
                temp.append(repeatString(s, index, repeatCount));
                repeatCount = 0;
            } else if (ch == ']') {
                break;
            } else {
                temp.append(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(temp);
        }
        return result;
    }
}