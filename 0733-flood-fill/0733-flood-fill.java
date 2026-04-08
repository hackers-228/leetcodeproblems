class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // Edge case: if color is same, no need to process
        if (originalColor == color) return image;

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary + color check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length 
            || image[r][c] != originalColor) {
            return;
        }

        // Fill color
        image[r][c] = newColor;

        // Explore 4 directions
        dfs(image, r + 1, c, originalColor, newColor); // down
        dfs(image, r - 1, c, originalColor, newColor); // up
        dfs(image, r, c + 1, originalColor, newColor); // right
        dfs(image, r, c - 1, originalColor, newColor); // left
    }
}