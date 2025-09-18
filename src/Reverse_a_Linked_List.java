
public class Reverse_a_Linked_List
{
	int data ;
	Reverse_a_Linked_List next;

	Reverse_a_Linked_List(int data){
		this.data=data;
		this.next=null;
	}
}
class Reverse{
	public Reverse_a_Linked_List head ;

	void Insert (int data){
		Reverse_a_Linked_List newNode =new Reverse_a_Linked_List(data);
		if(head==null){
			head=newNode;
			return;
		}
		newNode.next=head;// the newNode Points to the head --> which is the start.
		head=newNode; //head points to the newNode.
	}
	void Display(){
		Reverse_a_Linked_List current = head;
		if(head==null){
			System.out.println("null no node");
			return;
		}
		while (current!=null){
			System.out.print(current.data +"-->");
			current=current.next;
		}
		System.out.println("null");

	}
	void reverse(){
		Reverse_a_Linked_List current =head;
		Reverse_a_Linked_List pre =null;
		Reverse_a_Linked_List next =null;


		if(head==null){
			System.out.println("null");
			return;
		}

		while (current!=null){
			next=current.next;
			current.next=pre;
			pre=current;
			current=next;
		}
		head=pre;

	}


	//Using Recursion-->
	Reverse_a_Linked_List ReverseRecursion(Reverse_a_Linked_List head){

		if(head==null || head.next==null){
			return head;
		}

		Reverse_a_Linked_List Head = ReverseRecursion(head.next);
		head.next.next=head;
		head.next=null;

		return Head;


	}


	public static void main(String[] args)
	{
		Reverse l = new Reverse();
		l.Insert(1);
		l.Insert(2);
		l.Insert(3);
		l.Insert(4);
		l.Display();
//		l.reverse();
		System.out.println(l.head.data);
		l.Display();

		l.head =l.ReverseRecursion(l.head);
		l.Display();
		System.out.println(l.head.data);
	}
}