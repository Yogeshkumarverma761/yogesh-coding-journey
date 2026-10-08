class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;  // to track the depth of parentheses

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    result.append(ch);  // only add if it's not the outermost '('
                }
                count++;  // increase the depth
            } else {  // ch == ')'
                count--;  // decrease the depth
                if (count > 0) {
                    result.append(ch);  // only add if it's not the outermost ')'
                }
            }
        }

        return result.toString();
    }
}
