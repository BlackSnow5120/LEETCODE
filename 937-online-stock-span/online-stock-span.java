class StockSpanner {
    Stack<Integer> st;
    Stack<Integer> stind;

    int ind;
    public StockSpanner() {
        ind = 0;
        st = new Stack<Integer>();
        stind= new Stack<Integer>();
        
    }
    
    public int next(int price) {
        while(!st.empty() && price >= st.peek())
        {
            st.pop();
            stind.pop();
        }
        int span;
        if (st.empty()) {
            span = ind + 1;
        } else {
            span = ind - stind.peek();
        }

        st.push(price);
        stind.push(ind);
        ind++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */