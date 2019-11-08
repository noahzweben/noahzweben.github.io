public class MyList {

	private Node head;


	private class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data=data;
			this.next = next;
		}
	}


	public MyList(int count){
		head = null;
		addNodes(count);
	}

	public void addNode(int data){
		if (head == null) head = new Node(data,null);
		else {
			Node temp = head;
			while (temp.next !=null) temp = temp.next;
			temp.next = new Node(data,null);
		}
	}

	public void addNodes(int count){
		for (int i=0;i<count;i++) addNode(i);
	}


	public int halfway(){
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			System.out.println(fast.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;

	}

	public String toString(){
		String s = "";
		Node temp= head;
		while (temp!=null){
			s = s+", "+temp.data;
			temp = temp.next;
		}
		return s;
	}

	public static void main(String[] args) {
		MyList me = new MyList(9);
		System.out.println(me.toString());
		System.out.println(me.halfway());
	}

}
