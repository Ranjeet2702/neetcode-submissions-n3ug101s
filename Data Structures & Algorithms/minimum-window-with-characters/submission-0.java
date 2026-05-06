class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        // Step 1: t ki frequency map banao
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size(); // unique chars in t
        int formed   = 0;           // kitne satisfy hue

        Map<Character, Integer> have = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int resLeft = 0, resRight = 0;

        // Step 2: right pointer aage badhao
        while (right < s.length()) {
            char c = s.charAt(right);
            have.put(c, have.getOrDefault(c, 0) + 1);

            // Check karo kya is character ki frequency satisfy hui
            if (need.containsKey(c) && have.get(c).equals(need.get(c))) {
                formed++;
            }

            // Step 3: Jab window valid ho — left shrink karo
            while (left <= right && formed == required) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen   = right - left + 1;
                    resLeft  = left;
                    resRight = right;
                }

                // Left character window se hatao
                char leftChar = s.charAt(left);
                have.put(leftChar, have.get(leftChar) - 1);

                if (need.containsKey(leftChar) && 
                    have.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }
}