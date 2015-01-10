package leetcode;
/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.*/
public class MinStack {
	class MinStack {
	    LinkedList<Integer> st = new LinkedList<Integer>();
	    LinkedList<Integer> min = new LinkedList<Integer>();
	    public void push(int x) {
	        st.push(x);
	        if (min.isEmpty() || x <= min.peek()) {
	            min.push(x);
	        }
	    }

	    public void pop() {
	        
	        int i = st.pop();
	        if (i == min.peek()) {
	            min.pop();
	        }
	        
	    }

	    public int top() {
	        return st.peek();
	    }

	    public int getMin() {
	        return min.peek();
	    }
	}

}
