package LinkedLists;

import java.awt.List;
import java.util.HashSet;
import java.util.Stack;

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
			throw new Exception("Linked list is already empty !!!");

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
			throw new Exception("Linked list is already empty !!!");

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

	public void addElement(int data) {

		addAtTail(data);

	}

	public void addAtIndex(int data, int index) throws Exception {

		if (index < 0 || index > size)
			throw new Exception("Index is out of range !!!");

		if (index == 0) {
			addAtHead(data);
			return;
		}

		if (index == size) {
			addAtTail(data);
			return;
		}

		Node ptr = head;
		Node n = new Node(data);
		for (int i = 0; i < index - 1; i++)
			ptr = ptr.next;

		n.next = ptr.next;
		ptr.next = n;
		size++;
	}

	public void removeElement(int data) throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to remove !!!");
		}

		if (head.data == data) {
			removeFromHead();
			return;
		}

		if (tail.data == data) {
			removeFromTail();
			return;
		}

		Node cur_ptr = head;
		Node prev_ptr = null;
		while (cur_ptr != null) {
			if (cur_ptr.data == data) {
				prev_ptr.next = cur_ptr.next;
				size--;
				return;
			}
			prev_ptr = cur_ptr;
			cur_ptr = cur_ptr.next;
		}

		throw new Exception("No such element to remove !!!");

	}

	public void removeFromIndex(int index) throws Exception {
		if (head == null && tail == null) {
			throw new Exception("No node to remove !!!");
		}

		if (index < 0 && index >= index) {
			throw new Exception("Index is out of range !!!");
		}

		if (index == 0) {
			removeFromHead();
			return;
		}

		if (index == size - 1) {
			removeFromTail();
			return;
		}

		Node cur_ptr = head;
		Node prev_ptr = null;
		for (int i = 0; i < index; i++) {
			prev_ptr = cur_ptr;
			cur_ptr = cur_ptr.next;
		}

		prev_ptr.next = cur_ptr.next;
		size--;
		return;

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
			sb.append(" -> ");
			ptr = ptr.next;
		}
		sb.append("Null");
		return sb.toString();
	}

	public void removeDuplicatesWithHashTable() {

		Node cur_ptr = head;
		Node prev_ptr = null;
		HashSet<Integer> ht = new HashSet<Integer>();
		while (cur_ptr != null) {
			// System.out.println(cur_ptr.data);
			// System.out.println(ht.contains(cur_ptr.data));
			// System.out.println(ht);
			if (ht.contains(cur_ptr.data)) {
				prev_ptr.next = cur_ptr.next;
				size--;
			} else {
				ht.add(cur_ptr.data);
				prev_ptr = cur_ptr;
			}
			cur_ptr = cur_ptr.next;
		}
	}

	public void removeDuplicatesWithOutBuffer() {

		Node curr_ptr = head.next;
		Node prev_ptr = head;

		while (prev_ptr.next != null) {
			while (curr_ptr != null) {

				if (prev_ptr.data == curr_ptr.data) {
					prev_ptr.next = curr_ptr.next;
					curr_ptr = curr_ptr.next;
				} else {
					prev_ptr = curr_ptr;
					curr_ptr = curr_ptr.next;
				}
			}
		}

	}

	public int kthLastElement(int k) {

		Node fast_ptr = head;
		Node slow_ptr = null;
		for (int i = 0; i < k; i++) {
			fast_ptr = fast_ptr.next;
		}
		slow_ptr = head;

		while (fast_ptr != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next;
		}

		return slow_ptr.data;

	}

	public void deleteMiddleNode(Node node) {
		Node prev_ptr = null;
		Node curr_ptr = node;

		while (curr_ptr.next != null) {
			curr_ptr.data = curr_ptr.next.data;
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

		prev_ptr.next = null;

	}

	public void partitionArroundElement(int element, MyLinkedList ln) {
		MyLinkedList list = new MyLinkedList();
		Node dummy = new Node();
		dummy.next = head;
		Node prev_ptr = dummy;
		Node curr_ptr = head;

		while (curr_ptr != null) {
			if (curr_ptr.data >= element) {

				list.addAtTail(curr_ptr.data);
				prev_ptr.next = curr_ptr.next;

				curr_ptr = curr_ptr.next;
			} else {
				prev_ptr = curr_ptr;
				curr_ptr = curr_ptr.next;
			}
			// System.out.println(ln);
			// System.out.println(list);
		}

		prev_ptr.next = list.head;
		head = dummy.next;
	}

	public MyLinkedList sumReversedOrderLinkedLists(MyLinkedList l1, MyLinkedList l2) {

		MyLinkedList result = new MyLinkedList();

		MyLinkedList large;
		MyLinkedList small;

		int carry = 0;
		if (l1.size >= l2.size) {
			large = l1;
			small = l2;
		} else {
			large = l2;
			small = l1;
		}

		Node small_ptr = small.head;
		Node large_ptr = large.head;

		for (int i = 0; i < small.size; i++) {
			int sum = small_ptr.data + large_ptr.data + carry;

			carry = sum / 10;
			int digit = sum % 10;

			result.addAtTail(digit);
			small_ptr = small_ptr.next;
			large_ptr = large_ptr.next;
		}

		while (large_ptr != null) {
			int sum = large_ptr.data + carry;
			carry = sum / 10;
			int digit = sum % 10;
			result.addAtTail(digit);
			large_ptr = large_ptr.next;
		}

		if (carry > 0)
			result.addAtTail(carry);

		return result;
	}

	public MyLinkedList sumLinkedLists(MyLinkedList l1, MyLinkedList l2) {
		MyLinkedList result = new MyLinkedList();

		return result;
	}

	public boolean isPalindrome() {

		Stack<Integer> st = new Stack<Integer>();

		Node ptr = this.head;

		for (int i = 0; i < this.size / 2; i++) {

			st.push(ptr.data);

			ptr = ptr.next;

		}

		if (this.size % 2 != 0)

			ptr = ptr.next;

		while (ptr != null) {

			if (ptr.data != st.pop())

				return false;

			ptr = ptr.next;

		}

		return true;

	}

	public static void main(String[] args) throws Exception {

		MyLinkedList ln = new MyLinkedList();
		// System.out.println(ln.isEmpty());
		ln.addAtTail(1);
		ln.addAtTail(1);
		ln.addAtTail(3);
		ln.addAtTail(2);
		ln.addAtTail(1);
		// System.out.println(ln);
		// ln.removeDuplicatesWithHashTable();
		// ln.removeDuplicatesWithOutBuffer()
		// System.out.println(ln.kthLastElement(3));
		// ln.deleteMiddleNode(ln.head.next.next.next.next);

		// ln.addAtTail(3);
		// ln.addAtTail(5);
		// ln.addAtTail(8);
		// ln.addAtTail(5);
		// ln.addAtTail(10);
		// ln.addAtTail(2);
		// ln.addAtTail(1);
		// System.out.println(ln);
		// ln.partitionArroundElement(3, ln);
		// MyLinkedList l1 = new MyLinkedList();
		// l1.addAtTail(7);
		// l1.addAtTail(1);
		// l1.addAtTail(6);
		// MyLinkedList l2 = new MyLinkedList();
		// l2.addAtTail(5);
		// l2.addAtTail(9);
		// l2.addAtTail(5);
		// l2.addAtTail(1);
		System.out.println(ln.isPalindrome());
		// System.out.println(ln.sumReversedOrderLinkedLists(l1, l2));
		// System.out.println(ln);

		// System.out.println(ln.isEmpty());
		// System.out.println(ln.size());
		// System.out.println(ln);
		// ln.addAtTail(5);
		// ln.addAtTail(6);
		// ln.addAtTail(7);
		// System.out.println(ln);
		// ln.removeFromHead();
		// ln.removeFromHead();
		// ln.removeFromTail();
		// ln.removeFromTail();
		// System.out.println(ln.isEmpty());
		// System.out.println(ln.size());
		// System.out.println(ln);
		// ln.addElement(9);
		// System.out.println(ln);
		// ln.addAtIndex(7, 0);
		// System.out.println(ln);
		// ln.addAtIndex(10, 5);
		// System.out.println(ln);
		// ln.addAtIndex(7, 5);
		// System.out.println(ln);
		// ln.removeElement(2);
		// System.out.println(ln);
		// ln.removeElement(9);
		// System.out.println(ln);
		// ln.removeElement(7);
		// System.out.println(ln);
		// ln.removeFromIndex(0);
		// System.out.println(ln);
		// ln.removeFromIndex(1);
		// System.out.println(ln);

	}

}
