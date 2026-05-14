class Solution {
    public long sumScores(String s) {
        int n = s.length();
        long p = 31;                 // Prime base
        long m = 1000000007;         // Large prime modulo
        
        // --- Step 1: Precompute powers of p and prefix hashes ---
        long[] pow_p = new long[n + 1];
        long[] hash_arr = new long[n + 1];
        
        pow_p[0] = 1;
        hash_arr[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            // Precompute powers
            pow_p[i] = (pow_p[i - 1] * p) % m;
            
            // Convert char to a 1-based integer ('a' -> 1, 'b' -> 2, etc.)
            long char_val = s.charAt(i - 1) - 'a' + 1;
            
            // Build the prefix hash array
            hash_arr[i] = (hash_arr[i - 1] * p + char_val) % m;
        }
        
        // Use long because the total sum can exceed 32-bit integer limits (2.1 billion)
        long totalScore = 0;
        
        // --- Step 2: Iterate through all suffixes and Binary Search ---
        for (int i = 0; i < n; i++) {
            int low = 1;
            int high = n - i;
            int best_match = 0;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                
                // Compare the prefix of length 'mid' with the suffix chunk
                long prefix_hash = getHash(hash_arr, pow_p, 0, mid - 1, m);
                long suffix_hash = getHash(hash_arr, pow_p, i, i + mid - 1, m);
                
                if (prefix_hash == suffix_hash) {
                    best_match = mid;     // Match found, record it
                    low = mid + 1;        // Try to find a longer match
                } else {
                    high = mid - 1;       // Match failed, try a shorter match
                }
            }
            
            totalScore += best_match;
        }
        
        return totalScore;
    }
    private long getHash(long[] hash_arr, long[] pow_p, int L, int R, long m) {
        int length = R - L + 1;
        
        // Extract substring hash
        long val = (hash_arr[R + 1] - (hash_arr[L] * pow_p[length]) % m) % m;
        
        // Ensure the result is strictly positive
        return (val + m) % m;
    }
}