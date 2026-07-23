class Solution {

    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRemove++;
            } else if (ch == ')') {

                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }

        dfs(s, 0, 0, 0, leftRemove, rightRemove, new StringBuilder());

        return new ArrayList<>(ans);
    }

    private void dfs(String s,
                     int index,
                     int leftCount,
                     int rightCount,
                     int leftRemove,
                     int rightRemove,
                     StringBuilder path) {

        if (index == s.length()) {

            if (leftRemove == 0 && rightRemove == 0) {
                ans.add(path.toString());
            }

            return;
        }

        char ch = s.charAt(index);
        int len = path.length();

        if (ch == '(' && leftRemove > 0) {
            dfs(s, index + 1, leftCount, rightCount,
                    leftRemove - 1, rightRemove, path);
        }

        if (ch == ')' && rightRemove > 0) {
            dfs(s, index + 1, leftCount, rightCount,
                    leftRemove, rightRemove - 1, path);
        }

        path.append(ch);

        if (ch != '(' && ch != ')') {

            dfs(s, index + 1, leftCount, rightCount,
                    leftRemove, rightRemove, path);

        } else if (ch == '(') {

            dfs(s, index + 1, leftCount + 1, rightCount,
                    leftRemove, rightRemove, path);

        } else if (rightCount < leftCount) {

            dfs(s, index + 1, leftCount, rightCount + 1,
                    leftRemove, rightRemove, path);
        }

        path.setLength(len);
    }
}