
class MinStack {
    private Stack<int[]> s;  // stores [val, minVal] pairs

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            s.push(new int[]{val, val});
        } else {
            int minVal = Math.min(val, s.peek()[1]);
            s.push(new int[]{val, minVal});
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
    }
}