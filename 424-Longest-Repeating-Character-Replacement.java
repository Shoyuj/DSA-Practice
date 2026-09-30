class Solution {
    public int characterReplacement(String s, int k) {
        
        int l=0,len=0,max=0,maxfreq=0;
        int freq[] = new int[26];

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'A']++;
            maxfreq=Math.max(freq[s.charAt(i)-'A'],maxfreq);

            while((i-l+1)-maxfreq>k)
            {
                freq[s.charAt(l)-'A']--;
                l++;
                
            }

            max=Math.max(i-l+1,max);
        }
        return max;
    }
}