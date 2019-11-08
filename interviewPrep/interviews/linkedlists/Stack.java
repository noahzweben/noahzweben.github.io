
//sort a stack w/ another stack
public static Stack<Integer> sort(Stack<Integer> s) {
    Stack<Integer> r = new Stack<Integer>();

    while(!s.isEmpty()) {
        int tmp = s.pop();
        while(!r.isEmpty() && r.peek() > tmp) {
            s.push(r.pop());
        }
        r.push(tmp);
    }
    return r;
}

// sort a stack w/ recursion
sortStack(stack S)
	if stack is not empty:
		temp = pop(S);  
		sortStack(S); 
		sortedInsert(S, temp);

sortedInsert(Stack S, element)
	if stack is empty OR element > top element
		push(S, elem)
	else
		temp = pop(S)
		sortedInsert(S, element)
		push(S, temp)


//// stack with min
Push(int x) // inserts an element x to Special Stack 
1) push x to the first stack (the stack with actual elements)
2) compare x with the top element of the second stack (the auxiliary stack). Let the top element be y.
…..a) If x is smaller than y then push x to the auxiliary stack.
…..b) If x is greater than y then push y to the auxiliary stack.

int Pop() // removes an element from Special Stack and return the removed element 
1) pop the top element from the auxiliary stack.
2) pop the top element from the actual stack and return it.

The step 1 is necessary to make sure that the auxiliary stack is also updated for future operations.

int getMin() // returns the minimum element from Special Stack 
1) Return the top element of auxiliary stack.



