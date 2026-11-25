class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        // Build Trie
        for (String word : words) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        // Search in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node, List<String> result) {

        // Boundary check
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];
        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Word found
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        // Mark cell as visited
        board[i][j] = '#';

        // Search in four directions
        dfs(board, i + 1, j, next, result);
        dfs(board, i - 1, j, next, result);
        dfs(board, i, j + 1, next, result);
        dfs(board, i, j - 1, next, result);

        // Backtracking
        board[i][j] = ch;
    }
}
