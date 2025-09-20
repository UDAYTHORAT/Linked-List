package Questions;

public class Remove_duplicates_sorted_LL
{

	class Node{
		int data;
		Node next;

		Node(int data){
			this.data=data;
			this.next=null;
		}
		Node(int data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	Node head;

	void Insert(int data){
		Node newNode= new Node(data);
		if(head==null){
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}

	void Display(){
		Node current= head;
		while (current!=null){
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println("null");
	}

	// remove duplicates and keep one copy-->
	void RemoveDuplicates(Node head){
		Node current =head;
		if (current==null){
			System.out.println("null");
			return;
		}
		while (current.next!=null){
			if (current.data==current.next.data){
				current.next=current.next.next;
			}else {
				current=current.next;
			}
		}

	}

  // Remove duplicates and keep no copy of them-->
	Node RemoveDuplicateNodes(Node head){
		Node dummy = new Node(0,head);
		Node pre= dummy;
		Node current =head;


		while (current!=null){
			boolean isDupli=false;
			while (current.next!=null && current.data==current.next.data){
				current=current.next;
				isDupli=true;
			}
				if (isDupli){
					pre.next=current.next;
				}else
				{
					pre = pre.next;
				}
				current=current.next;
			}

      return dummy.next;
	}

	void Delete(){
		Node current =head;
		if(head==null){
			return;
		}

		while (current!=null){
			current=current.next;
		}
		head.next=null;
		head=null;

	}

	public static void main(String[] args)
	{
		Remove_duplicates_sorted_LL list = new Remove_duplicates_sorted_LL();

		list.Insert(3);
		list.Insert(3);
		list.Insert(2);
		list.Insert(2);
		list.Insert(2);
		list.Insert(1);
		list.Display();
		System.out.println("Remove the duplicate and keep one copy -->");
		list.RemoveDuplicates(list.head);
		list.Display();
		list.Delete();
		list.Display();

		list.Insert(4);
		list.Insert(3);
		list.Insert(3);
		list.Insert(2);
		list.Insert(2);
		list.Insert(2);
		list.Insert(1);
		list.Display();
		System.out.println("Remove the duplicate and keep no copy of them -->");
		list.head= list.RemoveDuplicateNodes(list.head);
		list.Display();


	}
}
