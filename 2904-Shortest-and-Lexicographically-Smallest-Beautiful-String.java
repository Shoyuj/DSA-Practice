class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0, ones = 0, min = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1')
                ones++;

            while (ones > k) {
                if (s.charAt(left++) == '1')
                    ones--;
            }

            if (ones == k) {
                while (s.charAt(left) == '0')
                    left++;

                String cur = s.substring(left, right + 1);

                if (cur.length() < min ||
                    (cur.length() == min && cur.compareTo(ans) < 0)) {
                    min = cur.length();
                    ans = cur;
                }
            }
        }

        return ans;
    }
}