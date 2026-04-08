class Solution {
    public int kthGrammar(int n, int k) {
        // Base case
        if (n == 1) return 0;

        int mid = 1 << (n - 2); // 2^(n-2)

        if (k <= mid) {
            // First half → same
            return kthGrammar(n - 1, k);
        } else {
            // Second half → flipped
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
}