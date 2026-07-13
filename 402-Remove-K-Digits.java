class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack <Character> st = new Stack<>();

        for(int i=0; i<num.length(); i++){
            char idx = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()-0 > idx-0){
                st.pop();
                k--;
            }
            st.push(idx);
        }
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        ans.delete(0, i);

        if(ans.length() == 0) return "0";

        return ans.toString();
    }
}