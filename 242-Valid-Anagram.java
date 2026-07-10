class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] dataHolder = new int [26];
        int ordinal = (int) 'a';


        for (char i : s.toCharArray()){
            dataHolder[(int)i- ordinal] += 1;

        }

        for (char j : t.toCharArray()){
            dataHolder[(int)j- ordinal] -= 1;

        }
        for (int l : dataHolder){
            if(l !=0 ){
                return false;
            }

        }
        return true;
        
    }
}