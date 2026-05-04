class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class MinStack {
    Stack<Pair>st; 
    public MinStack() {
        st = new Stack();
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }else{
            int minval = Math.min(val,st.peek().second);
            st.push(new Pair(val,minval));

        }
    }
    
    public void pop() {
        st.pop();
        
    }
    
    public int top() {
        return st.peek().first;
        
    }
    
    public int getMin() {
        return st.peek().second;
        
    }
}
