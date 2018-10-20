package arboles;

public class Node {
	public Integer data;
	public Node right;
	public Node left;
	public int x;
	public int y;
	
	public Node() {
		data = (Integer) null;
		right = null;
		left = null;
	}
	
	Node(Integer data){
		this.data = data;
	}

}
