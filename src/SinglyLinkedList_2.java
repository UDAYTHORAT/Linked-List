
class  Node1{
	int data;
	Node1 next;

	Node1(int data){
		this.data=data;
		this.next=null;
		int size=0;

	}
}

public class SinglyLinkedList_2
{
	Node1 head;
	//InsertFirst at first -->
	void InsertFirst(int data){
		Node1 newNode = new Node1(data);
		Node1 current = head;

		if (head==null){
			head=newNode;
		}
		newNode.next=current;
		head=newNode;

	}
	//InsertFirst at last-->
	void InsertLast(int data){
		Node1 current =head;
		Node1 newNode =new Node1(data);

		if (head==null){
			 head=newNode;
			 return;
		}

		while (current.next!=null){
			current=current.next;
		}
		current.next=newNode;
		newNode.next=null;

	}

	//InsertFirst in between-->
	void InsertBetweenBefore(int data, int LastNode){
		Node1 current =head;
		Node1 pre =head;
		Node1 newNode =new Node1(data);

		if(current==null || current.next ==null){
			System.out.println("There should be two elements");
			return;
		}
		while (current.data!=LastNode){
			pre=current;
			current=current.next;
		}
		pre.next=newNode;
		newNode.next=current;

	}

	//delete a node-->
	void Delete(int node){

		Node1 current=head;
		if (head.data==node){
			head=head.next;
			return;
		}

		while (current.next.data!= node){
			current=current.next;
		}
		current.next=current.next.next;

	}
	//Delete in the range -->
	void DeleteinRange(int from, int to) {
		if (head == null) return;

		// case: "from" is at head
		if (head.data == from) {
			Node1 temp = head;
			while (temp != null && temp.data != to) {
				temp = temp.next;
			}
			if (temp != null) head = temp.next; // skip the whole range
			return;
		}

		// find node before "from"
		Node1 prev = head;
		while (prev.next != null && prev.next.data != from) {
			prev = prev.next;
		}
		if (prev.next == null) return; // "from" not found

		// move until "to"
		Node1 temp = prev.next;
		while (temp != null && temp.data != to) {
			temp = temp.next;
		}
		if (temp != null) prev.next = temp.next; // unlink range
	}


	//display-->
	void display(){
		if(head==null){
			System.out.println("null");
			return;
		}
		Node1 current = head;

		while (current!=null){
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println("null");

	}

	public static void main(String[] args)
	{
	  SinglyLinkedList_2 list=new SinglyLinkedList_2();
	  list.InsertFirst(1);
	  list.InsertFirst(2);
	  list.InsertFirst(3);
	  list.InsertFirst(4);
	  list.InsertLast(14);
	  list.Delete(3);
	  list.Delete(2);
	  list.Delete(4);
	  list.Delete(1);
	  list.Delete(14);
	  list.InsertLast(3);
	  list.InsertFirst(1);
	  list.InsertBetweenBefore(2, 3);
	  list.InsertBetweenBefore(4, 3);
	  list.InsertBetweenBefore(5, 2);
	  list.display();
	  list.DeleteinRange(1,4);

	  list.display();

	}
}
