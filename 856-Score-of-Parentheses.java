class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(0);
            }

            else {
                int inside = st.pop();

                if (inside == 0)
                    inside = 1;
                else
                    inside = inside * 2;

                int prev = st.pop();
                st.push(prev + inside);
            }
        }

        return st.peek();
    }
}