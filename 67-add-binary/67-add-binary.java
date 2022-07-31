class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        String reverseStringA = new StringBuilder(a).reverse().toString();
        String reverseStringB = new StringBuilder(b).reverse().toString();

        StringBuilder answer = new StringBuilder();
        int i = 0, j = 0;
        for ( ; i < reverseStringA.length() && j < reverseStringB.length(); i++, j++) {
            int tempA = reverseStringA.charAt(i) - '0';
            int tempB = reverseStringB.charAt(j) - '0';

            int sum = tempA + tempB + carry;
            answer.append(sum % 2);
            carry = sum / 2;
        }

        int indexOfRemainedString = 0;
        String remainedString = null;
        if (i >= reverseStringA.length() && j >= reverseStringB.length()) {
            if (carry == 1) {
                answer.append(carry);
            }
            return answer.reverse().toString();
        }

        if (i >= reverseStringA.length()) {
            indexOfRemainedString = j;
            remainedString = reverseStringB;
        } else {
            indexOfRemainedString = i;
            remainedString = reverseStringA;
        }

        for (int k = indexOfRemainedString; k < remainedString.length(); k++) {
            int temp = remainedString.charAt(k) - '0';

            int sum = temp + carry;
            answer.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }
}