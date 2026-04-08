class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, StringBuilder path, List<String> result) {
        // Base case
        if (index == s.length()) {
            result.add(path.toString());
            return;
        }

        char c = s.charAt(index);

        // If digit → only one choice
        if (Character.isDigit(c)) {
            path.append(c);
            backtrack(s, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); // backtrack
        } else {
            // Lowercase
            path.append(Character.toLowerCase(c));
            backtrack(s, index + 1, path, result);
            path.deleteCharAt(path.length() - 1);

            // Uppercase
            path.append(Character.toUpperCase(c));
            backtrack(s, index + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}