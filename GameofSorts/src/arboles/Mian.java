package arboles;

public class Mian {

	public static void main(String[] args) {
		GrapichBTree tree = new GrapichBTree();
		tree.add(12);
		tree.add(0);
		tree.add(15);
		tree.add(241);
		tree.add(32);
		tree.add(65);
		tree.add(5);
		tree.add(56);
		tree.add(156);
		tree.add(64);
		
		tree.getReady(tree.root);
		tree.drawTree();

	}

}
