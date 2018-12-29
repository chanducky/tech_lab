package tree;

/**
 * @author chandrakumar
 *
 */

/*

  				mirror
		3			|              3           
	5		4		|         4			5
2		6			|			   6		2


 */
public class TreeMirror {

	Node createTree(){
		Node root = new Node(3);
		root.left= new Node(5);
		root.right= new Node(4);

		root.left.left= new Node(2);
		root.left.right= new Node(6);


		return root;
	}

	void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	void mirror(Node node){
		if(node!=null){
			Node tempLeft = null;
			Node tempRight = null;

			if(node.left!=null){
				tempLeft=node.left;
			}
			if(node.right!=null){
				tempRight=node.right;
			}

			node.right=tempLeft;
			node.left=tempRight;

			mirror(node.left);
			mirror(node.right);
		}
	}

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}

	public static void main(String[] args) {
		TreeMirror tm = new  TreeMirror();
		Node root = tm.createTree();
		tm.inorder(root);
		tm.mirror(root);
		System.out.println("------------mirror-------------");
		tm.inorder(root);
	}

}

