package arboles;

public class ArbolB {
	public Node root;
	Node temp;
	static int cuantos=0;
	static int w=120,h=80;
	
	public ArbolB() {
		root = null;
	}
	
	public void add(Integer data) {
		Node node = new Node(data);
		if(this.root == null) {
			this.root = node;
			this.root.x = 500;
			this.root.y = 10;
			cuantos++;
		}else {
			boolean ok = true;
			temp = root;
			while(ok) 
				if(temp.data > data) {
					if(temp.left==null) {
						temp.left = node;
						temp.left.x = temp.x - w;
						temp.left.y = temp.y + 80;
						cuantos++;
						w -= 5;
						ok = false;
					}
					else {
						temp = temp.left;
					}
				}
				else {
					if(temp.right==null) {
						temp.right = node;
						temp.right.x = temp.x + w;
						temp.right.y = temp.y + 80;
						cuantos++;
						w -= 5;
						ok = false;
					}else {
						temp = temp.right;
					}
				}
			
		}
	}
}
