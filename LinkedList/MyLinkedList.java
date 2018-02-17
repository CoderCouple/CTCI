package Test;

public class MyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addAtHead(int data) {
		Node node = new Node(data);

		if (head == null && tail == null) {

			head = node;
			tail = node;
			size++;
			return;
		}

		node.next = head;
		head = node;
		size++;
		return;

	}

	public void addAtTail(int data) {
		Node node = new Node(data);

		if (head == null && tail == null) {
			head = node;
			tail = node;
			size++;
			return;

		}

		tail.next = node;
		tail = node;
		size++;
		return;
	}

	public int removeFromHead() throws Exception {
		int data;
		if (head == null && tail == null)
			throw new Exception("Linked list is already empty!!!");

		data = head.data;

		if (head == tail && tail != null && head != null) {
			head = null;
			tail = null;
			size--;
			return data;
		}

		head = head.next;
		size--;
		return data;
	}

	public int removeFromTail() throws Exception {
		int data;
		Node ptr = head;
		if (head == null && tail == null)
			throw new Exception("Linked list is already empty!!!");

		data = tail.data;

		if (head == tail && tail != null && head != null) {
			head = null;
			tail = null;
			size--;
			return data;
		}

		while (ptr.next.next != null)
			ptr = ptr.next;

		tail = ptr;
		ptr.next = null;
		size--;
		return data;

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		Node ptr = head;

		while (ptr != null) {
			sb.append(ptr.data);
			sb.append(" ");
			ptr = ptr.next;
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {

		MyLinkedList ln = new MyLinkedList();
		System.out.println(ln.isEmpty());
		ln.addAtHead(1);
		ln.addAtHead(2);
		ln.addAtHead(3);
		ln.addAtHead(4);
		System.out.println(ln.isEmpty());
		System.out.println(ln.size());
		System.out.println(ln);
		ln.addAtTail(5);
		ln.addAtTail(6);
		ln.addAtTail(7);
		System.out.println(ln);
		ln.removeFromHead();
		ln.removeFromHead();
		ln.removeFromTail();
		ln.removeFromTail();
		System.out.println(ln.isEmpty());
		System.out.println(ln.size());
		System.out.println(ln);
		
	
	}

}
