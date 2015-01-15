public interface List
{
	public void addNode(String value);
	public void insertNode(String value, int position);
	public boolean  removeNode(String value);
	public int find(String value);
	public int getLength();
	public void printList();
	public Node findNodeVal(String song1);
	public void swap(Node n1, Node n2);
}