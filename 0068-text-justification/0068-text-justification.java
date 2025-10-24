class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();
            if (j == words.length || gaps == 0) {
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ").append(words[k]);
                }
                while (sb.length() < maxWidth)
                    sb.append(" ");
            } else {
                int totalSpaces = maxWidth - (lineLen - gaps);
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    sb.append(" ".repeat(spacePerGap + (k - i < extraSpaces ? 1 : 0)));
                }
                sb.append(words[j - 1]);
            }

            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}


