class MinStack {
    Stack<Integer> st;
    Stack<Integer> st1;

    public MinStack() {
        st = new Stack<>();
        st1 = new Stack<>();
    }

    public void push(int val) {
        if (st.empty()) {
            st1.push(val);
        } else {
            if (val < st1.peek()) {
                st1.push(val);
            } else {
                st1.push(st1.peek());
            }
        }
        st.push(val);

    }

    public void pop() {
        st1.pop();
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return st1.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */