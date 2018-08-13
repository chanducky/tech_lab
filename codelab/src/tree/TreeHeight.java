package tree;

public class TreeHeight {

	static class  Node{
		int data;
		Node left,right;
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
	
	static void  inorderTravarsal(Node node){
		if(node.left!=null){
			inorderTravarsal(node.left);
		}
		if(node!=null){
			System.out.println(" "+ node.data);
		}
		if(node.right!=null){
			inorderTravarsal(node.right);
		}
	}
	
	static int treeHeight(Node node){
		int leftHeight =0;
		int rightHeight =0;
		
		if(node.left!=null){
			leftHeight= 1+treeHeight(node.left);
		}
		if(node.right!=null){
			rightHeight= 1+treeHeight(node.right);
		}
		if(leftHeight>rightHeight){
			return leftHeight;
		}
		return rightHeight;
	}
	
	public static void main(String[] args) {
		
		Node root =new Node();
		root.data=5;
		
		root.left = new Node();
		root.left.data =3;
		
		root.right = new Node();
		root.right.data =10;
		
		root.left.left = new Node();
		root.left.left.data =20;

		root.left.right = new Node();
		root.left.right.data =21;
		
		
		root.right.left = new Node();
		root.right.left.data =1;
		
		root.right.left.right = new Node();
		root.right.left.right.data =7;
		
		// inorderTravarsal(root);
		
		System.out.println(" tree height ="+ treeHeight(root));
	}

	
}

