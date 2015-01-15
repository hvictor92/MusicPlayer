
public class Node 
{
	public int item;
	private Node next;
	private String value;
	
	public Node(int newItem)
	{
		item = newItem;
		next = null;
	}
    public Node(int newItem, Node nextNode)
    {
    	item = newItem;
    	next = nextNode;
    }
    
    public Node(String words) 
    {
		value = words;
	}
	public void setItem(int newItem)
    {
    	item = newItem;
    }
	
	public void setValue(String newItem)
    {
    	value = newItem;
    }
    
    public void setNext(Node nextNode)
    {
    	this.next = nextNode;
    }
    
    public int getItem()
    {
    	return item;
    }
    
    public Node getNext()
    {
    	return this.next;
    }
    public String getValue()
    {
    	return this.value;
    }
	
}
