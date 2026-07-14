class StockSpanner {
    
    Stack<int[]> st = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {

        int ctr = 1;

        while(!st.isEmpty() && price>=st.peek()[0]){
            ctr+=st.pop()[1];
        }
        st.push(new int[]{price,ctr});
        return ctr;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */