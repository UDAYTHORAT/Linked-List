public class DLL
{
	int data;
	DLL next;
	DLL prev;

	DLL head;
	DLL tail;
	int size;

	DLL(){
		size=0;
	}

	DLL(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}

	void InsertFirst(int data){
		DLL node = new DLL(data);

		node.next=head;
		node.prev=null;
		if(head!=null){
			head.prev=node;
		}
		head=node;

	}

	void Display(){
		DLL current =head;

		while (current!=null){
			System.out.print(current.data+" <=> ");
			current=current.next;
		}
		System.out.println("null");
	}

	void Revers(){
		DLL current =head;
		while (current!=null){
			tail=current;
			current=current.next;
		}

		DLL last =tail;
		while (last!=null){
			System.out.print(last.data+" <=> ");
			last=last.prev;
		}
		System.out.println("null");
	}

	void InsertLast(int data){
		DLL newNode = new DLL(data);
		DLL current = head;

		while (current!=null){
			tail=current;
			current=current.next;
		}
		tail.next=newNode;
		newNode.next=null;
		newNode.prev=tail;

	}

	void InsertBetween(int data,int node){
		DLL newNode = new DLL(data);
		DLL current = head;
		DLL NodeBefore=null;

		while (current.data!= node){
			NodeBefore=current;
			current=current.next;
		}

		assert NodeBefore != null;
		NodeBefore.next=newNode;
		newNode.prev=NodeBefore;
		newNode.next= current;

	}
	void Delete(int node){
		DLL current = head;
		DLL prev=null;

		if (current.data==node){
			head=current.next;
			current.prev=null;
			return;
		}

		while (current.data!=node){
			prev=current;
			current=current.next;
		}

		prev.next=current.next;
	}

	public static void main(String[] args)
	{
		DLL list = new DLL();
		list.InsertFirst(1);
		list.InsertFirst(2);
		list.InsertFirst(3);
		list.Display();
		list.Revers();
		list.InsertLast(4);
		list.InsertFirst(0);
		list.Display();
		list.InsertBetween(7, 3);
		list.Display();
		list.Delete(3);
		list.Display();


	}
}
