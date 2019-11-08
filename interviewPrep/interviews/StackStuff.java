import java.util.ArrayDeque;

class StackStuff{

	private ArrayDeque<Integer> stack;

	public StackStuff(){
		stack = new ArrayDeque<>();
	}

	public void enque(Integer i){
		stack.push(i);
	}

	public Integer deque(){
		if (stack.size()==0) return null;
		if (stack.size()==1) return stack.pop();
		else {
			Integer temp = stack.pop();
			Integer result = deque();
			stack.push(temp);
			return result;
		}
	}










	
	public static ArrayDeque<Integer> sortStack(ArrayDeque<Integer> sortMe){
		ArrayDeque<Integer> temp = new ArrayDeque<>();
		
		while (sortMe.size()>0){
			Integer hold = sortMe.pop();
			while (temp.size()>0 && temp.peek()>hold) {
				sortMe.push(temp.pop());
			}
			temp.push(hold);
		}
		return temp;
	}


	public static void sortRec(ArrayDeque<Integer> sortMe){
		if (sortMe.size()>0){
			Integer temp = sortMe.pop();
			sortRec(sortMe);
			sortedInsert(temp,sortMe);
		}
	}



	public static void sortedInsert(Integer num, ArrayDeque<Integer> sortMe){
		if (sortMe.size()==0 || num>sortMe.peek()) sortMe.push(num);
		else {
			Integer temp = sortMe.pop();
			sortedInsert(num,sortMe);
			sortMe.push(temp);
		}

	}

	
	public static void main(String[] args) {
		ArrayDeque<Integer> me = new ArrayDeque<>();
		for (int i=10;i>0;i-=2){
			me.push(i);
		}
		for (int i=9;i>0;i-=2){
			me.push(i);
		}
		System.out.println(me.toString());
		// me = sortStack(me);
		sortRec(me);
		System.out.println(me.toString());

		StackStuff hello = new StackStuff();
		for (Integer i=10;i>0;i--){
			hello.enque(i);

		}
		System.out.println(hello.deque());
	}
}