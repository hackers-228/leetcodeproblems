import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // store full word
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {

        char c = board[i][j];

        // stop if visited or no prefix match
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        // found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[i][j] = '#'; // mark visited

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];

            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                dfs(board, ni, nj, node, result);
            }
        }

        board[i][j] = c; // backtrack
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        return root;
    }
}