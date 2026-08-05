class Solution {
    public int evalRPN(String[] tokens) {
        
		
    Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            // Check if the token is an operator
            if (token.equals("+")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            } else if (token.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            } else if (token.equals("*")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            } else if (token.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right); // Integer division truncates towards zero
            } else {
                // If it's not an operator, it must be a number
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The final result is the only item left in the stack
        return stack.pop();
    	
	
    }
}
