class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> bank = new HashSet<>();

        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (bank.add(ch)) {
                continue;
            }
     
            res = Math.max(res, i - left);
            while (s.charAt(left) != ch) {
                bank.remove(s.charAt(left));
                left++;
            }

            left++;
        }

        return Math.max(res, s.length() - left);
    }
}