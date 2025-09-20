package Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge_two_Sorted_LL
{
	class Node{
		int data;
		Node next;

		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node head;

	void InsertLast(int data){
	Node newNode =new Node(data);
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

	void Display(){
		Node current=head;
		while (current!=null){
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println("null");
	}

	Merge_two_Sorted_LL Merge(Merge_two_Sorted_LL first,Merge_two_Sorted_LL second ){
		Node h1= first.head;
		Node h2 =second.head;

		Merge_two_Sorted_LL ans =new Merge_two_Sorted_LL();

		while (h1!=null && h2!=null){
			if(h1.data < h2.data){
				ans.InsertLast(h1.data);
				h1=h1.next;
			}else {
				ans.InsertLast(h2.data);
				h2=h2.next;
			}
		}
		if(h1!=null){
			ans.InsertLast(h1.data);

		}
		if(h2!=null){
			ans.InsertLast(h2.data);

		}

		return ans;
	}

	public static void main(String[] args)
	{
		Merge_two_Sorted_LL l= new Merge_two_Sorted_LL();
		l.InsertLast(1);
		l.InsertLast(3);
		l.InsertLast(5);
		l.Display();
		Merge_two_Sorted_LL l2= new Merge_two_Sorted_LL();
		l2.InsertLast(1);
		l2.InsertLast(2);
		l2.InsertLast(4);
		l2.Display();

		Merge_two_Sorted_LL ans = l2.Merge(l2,l);
		ans.Display();
	}
}
