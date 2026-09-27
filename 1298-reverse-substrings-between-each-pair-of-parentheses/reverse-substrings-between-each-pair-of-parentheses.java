
class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                result.push(curr);
                curr = new StringBuilder();

            } else if (ch == ')') {
                curr.reverse();

                StringBuilder prev = result.pop();
                prev.append(curr);
                curr = prev;

            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}