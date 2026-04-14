class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = st.pop();
                int a = st.pop();
                int res = apply(a, b, token);
                st.push(res);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/");
    }

    private int apply(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return a / b;
        }
    }
}