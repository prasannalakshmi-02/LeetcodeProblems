class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        // Edge case: An IP address must have between 4 and 12 characters.
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> currentSegments, String s, int index) {
        // 1. BASE CASE: Do we have exactly 4 segments?
        if (currentSegments.size() == 4) {
            // Did we also use up all the characters in the string?
            if (index == s.length()) {
                // We found a valid IP! Join the segments with dots and take a snapshot.
                result.add(String.join(".", currentSegments));
            }
            return; // Backtrack! (Whether it was successful or a dead end)
        }

        // 2. ITERATE: At our current position, try taking chunks of length 1, 2, and 3.
        for (int len = 1; len <= 3; len++) {
            
            // Prevent going out of bounds of the string
            if (index + len > s.length()) break; 
            
            // Slice the chunk
            String chunk = s.substring(index, index + len);
            
            // PRUNING: Verify the chunk follows IPv4 rules
            if (isValidPart(chunk)) {
                
                // STEP 1: CHOOSE
                currentSegments.add(chunk);
                
                // STEP 2: EXPLORE (Move the index forward by the length of the chunk we took)
                backtrack(result, currentSegments, s, index + len);
                
                // STEP 3: UN-CHOOSE (Remove the chunk so we can try the next length)
                currentSegments.remove(currentSegments.size() - 1);
            }
        }
    }

    // Helper method to validate the IPv4 rules
    private boolean isValidPart(String s) {
        // Rule 1: No leading zeros (unless the string is literally just "0")
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        // Rule 2: Value must be <= 255
        // (We parse to int safely because we already restricted length to max 3)
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

}