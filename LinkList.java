
public class LinkList 
{
	Node head;
	private Node tail;
	private int length;
	
	public LinkList()
	{
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addNode(String value)
	{
		Node n = new Node(value);
		if(head == null)
		{
			head= n;
			length++;
			head.setItem(length);
		}
		else
		{
			if(tail == null)
			{
				head.setNext(n);
				tail = n;
				length++;
				n.setItem(length);
			}
			else
			{
				tail.setNext(n);
				tail = n;
				length++;
				n.setItem(length);
			}
			
		}
	}
	
	public void insertNode(String value, int position)
	{
		Node n    = this.findNodeVal(value);
		Node prev = this.findNodeNum(position-1);
		Node next = this.findNodeNum(position+1);
		    if(position == 1)
		    {
		    	head = n;
		    	n.setNext(next);
		    	n.setItem(position);
		    }
		    else if (position > 1)
		    {
		    	prev.setNext(n);
		    	n.setNext(next);
		    	n.setItem(position);				
		    }
	}	
	
	public void removeNode(String value)
	{
		int position = (this.findNodeVal(value)).getItem();
		Node prev = this.findNodeNum(position-1);
		Node next = this.findNodeNum(position+1);
		Node pointer = next;
		int counter = position;
		if(prev == null)
		{
			head= head.getNext();
			length--;
			while(pointer != null)
			{
				pointer.setItem(counter);
				counter++;
				pointer = pointer.getNext();
			}
		}
		else if (next == null)
		{
			prev.setNext(null);
			tail = prev;
			length--;
		}
		else
		{
			prev.setNext(next);
			length--;
			while(pointer != null)
			{
				pointer.setItem(counter);
				counter++;
				pointer = pointer.getNext();
			}
		}		
	}
	
	public void swap(Node n1, Node n2)
	{
		int item1 = n1.getItem();
		int item2 = n2.getItem();
		int itemCounter = 1;
		
		n1.setItem(item2);
		n2.setItem(item1);
		
		while(itemCounter != length-2)
		{
			head = this.findNodeNum(1);
			this.findNodeNum(itemCounter).setNext(this.findNodeNum(itemCounter+1));
			itemCounter++;
		}
	}
	
	public int find(String value)
	{
		Node pointer = head;
		int count = 0;
		
		for(int c = 0; c < length; c++)
		{
			if(pointer.getValue() == value)
			{
				return pointer.getItem();				
			}
			else
			{
				pointer = pointer.getNext();
				count++;	
			}
		}
		return count;	
	}
	
	public Node findNodeNum(int num)
	{
		Node pointer = head;		
		while(pointer.getItem() != num)
		{
			if(pointer.getItem() == num)
			{
				return pointer;
			}
			else
			{
				pointer = pointer.getNext();
			}
		}
		return pointer;
	}
	
	public Node findNodeVal(String value)
	{
		Node pointer = head;
		
		while(pointer.getValue() != value)
		{
			if(pointer.getValue().equals(value))
			{
				return pointer;
			}
			else
			{
				pointer = pointer.getNext();
			}
		}
		return pointer;
	}
	
	public int getLength() 
	{
		return length;
	}
	
	public void printList()
	{
	   int curr = 1;
			   
	   while(curr != length+1)
	   {
		   System.out.println(this.findNodeNum(curr).getItem()+". "+this.findNodeNum(curr).getValue());
		   curr++;
	   }	
	}


}
