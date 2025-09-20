package Questions;

public class LL_using_Recursion {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	Node Insert(int index, int val, Node current) {
		/*
		 * Example visualization:
		 * Suppose list: 1 -> 2 -> 3 -> null
		 * Insert 10 at index 2:
		 * Call: Insert(2,10,head)
		 *
		 * Step 1: current = 1, index = 2
		 *   Not index 0, so recurse: current.next = Insert(1,10, current.next)
		 *
		 * Step 2: current = 2, index = 1
		 *   Not index 0, recurse: current.next = Insert(0,10, current.next)
		 *
		 * Step 3: current = 3, index = 0
		 *   Base case: create new Node(10)
		 *   newNode.next = current (3)
		 *   Return newNode (10)
		 *
		 * Step 4: Back to current=2
		 *   Set 2.next = 10
		 *   Return 2
		 *
		 * Step 5: Back to current=1
		 *   Set 1.next = 2
		 *   Return 1 (head remains 1)
		 *
		 * Final list: 1 -> 2 -> 10 -> 3 -> null
		 */

		// Base case: index == 0, insert new node here
		if (index == 0) {
			Node newNode = new Node(val); // create new node with value
			newNode.next = current;       // link new node to current node

			// If inserting at the front, update head automatically
			if (current == head) {
				head = newNode;
			}

			return newNode; // return new node as head of this sublist
		}

		// Recursive step: go deeper into the list
		current.next = Insert(index - 1, val, current.next);

		// After recursion, return current node so previous node can link correctly
		return current;
	}

	void Display(Node current) {
		/*
		 * Display function is recursive:
		 * Example list: 1 -> 2 -> 10 -> 3 -> null
		 * Call Display(head)
		 * Prints: 1->2->10->3->null
		 */
		if (current == null) {
			System.out.println("null");
			return;
		}

		System.out.print(current.data + "->");
		Display(current.next); // recurse to next node
	}

	public static void main(String[] args) {
		LL_using_Recursion l = new LL_using_Recursion();

		// Insert 3 at index 0 → list: 3->null
		l.Insert(0, 3, l.head);

		// Insert 2 at index 0 → list: 2->3->null
		l.Insert(0, 2, l.head);

		// Insert 1 at index 0 → list: 1->2->3->null
		l.Insert(0, 1, l.head);

		// Insert 10 at index 2 → list: 1->2->10->3->null
		l.Insert(2, 10, l.head);

		// Insert 11 at index 0 → list: 11->1->2->10->3->null
		l.Insert(0, 11, l.head);
		l.Insert(5, 12, l.head);
		l.Insert(6, 13, l.head);

		// Display the final linked list
		l.Display(l.head);

		// Print head value to confirm automatic head update
		System.out.println(l.head.data); // 11
	}
}
