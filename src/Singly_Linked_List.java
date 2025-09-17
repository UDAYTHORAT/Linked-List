
class Node{
	String data;
	Node next =null;

	Node(String data){
		this.data=data;
		this.next=null;
	}
}

public class Singly_Linked_List
{
	Node head;

	//Insert at  start -->
	void InsertAtStart(String data){
		Node newNode =new Node(data);
		if(head==null){
			head=newNode;
			return;
		}
		newNode.next = head;
		head=newNode;
	}

	//Insert at the Last -->
	void InsertAtLast(String data){
		Node newNode = new Node(data);
		Node current =head;

		if(head==null){
			head=newNode;
			return;
		}
		while (current.next!=null){
			current=current.next;
		}
		current.next=newNode;
		newNode.next=null;
	}


	//Insert at between -->

	void InsertAtBetween(String data, String node){

		Node newNode = new Node(data);
		Node current = head;
		while ( current!=null &&!current.next.data.equals(node)){
			current=current.next;

		}
		if (current == null || current.next==null) {
			System.out.println("Node " + node + " not found.");
			return;
		}
		newNode.next=current.next;
		current.next=newNode;

	}

	//Delete a Node-->
	void DeleteANode(String node){

		Node current = head;
		Node pre =head;

		if(head.data.equals(node)){
			head= head.next;
			return;
		}

		while ( current!= null &&!current.data.equals(node)){
			pre=current;
			current=current.next;
		}
		if (current==null){
			return;
		}

		pre.next=current.next;

	}


	//Display  all Nodes -->
	void Display(){
		Node current =head;
		while (current!= null){
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println("null");
	}




	public static void main(String[] args)
	{
		Singly_Linked_List list = new Singly_Linked_List();

		list.Display();

		//insert at the start-->
		System.out.println("Insert at first");
		list.InsertAtStart("My");
		list.Display();
		System.out.println("------------------");

		//insert at last-->
		System.out.println("Insert at last");
		list.InsertAtLast("name");
		list.InsertAtLast("Uday");
		list.Display();
		System.out.println("------------------");

		//insert at between-->
		System.out.println("Add --> (is) before Uday and (first) before name");
		list.InsertAtBetween("is","Uday");
		list.InsertAtBetween("first","name");

		list.Display();

		System.out.println("------------------");
		System.out.println();

		//delete a node-->
		list.Display();
		System.out.println("Delete --> (first) & (is) ");
		list.DeleteANode("first");
		list.DeleteANode("is");
		list.Display();
	}

}





