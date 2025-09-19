public class Circular_Linked_List
{
	private  class Node{
		int data;
		Node next;

		Node(int data){
			this.data=data;
			this.next=null;
		}

	}
	private Node head;
	private  Node tail;


	void InsertFirst(int data){
		Node newNode = new Node(data);
		if(head==null){
			head=newNode;
			tail=newNode;
			tail.next=head;
			return;
		}
		newNode.next=head;
		head=newNode;
		tail.next=head;
	}

	void InsertLast(int data){
		Node current =tail;
		Node newNode =new Node(data);

		if(head==null){
			head=newNode;
			tail=newNode;
			tail.next=head;
			return;
		}
		current.next=newNode;
		newNode.next=head;
		tail=newNode;
	}

	void Delete(int node){
		Node current =head;
		Node pre=null;

		if (current.data==node){
			head=head.next;
			tail.next=head;
			return;
		}

		while (current.data!=node){
			pre=current;
			current=current.next;
		}

		pre.next=current.next;
	}



	void Display(){
		Node current=head;
	do{
		System.out.print(current.data+"->");
		current=current.next;
	}while (current!=head);

		System.out.println(head.data+"(head)");
	}


	public static void main(String[] args)
	{
		Circular_Linked_List c=new Circular_Linked_List();

		c.InsertFirst(1);
		c.InsertFirst(2);
		c.InsertFirst(3);
		c.InsertFirst(4);
		c.Display();
		c.InsertLast(5);
		c.Display();
		c.InsertFirst(7);
		c.Display();
		c.Delete(4);
		c.Display();
		c.Delete(7);
		c.Display();
		c.Delete(3);
		c.Display();
		c.InsertFirst(9);
		c.Display();

	}

}

