package tree;

public class BinarySearchTree {

	class Node {
		int key;
		Node left,right;
		public Node(int key) {
			super();
			this.key = key;
			this.left = null;
			this.right = null;
		}
		@Override
		public String toString() {
			return "Node [key=" + key + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	
	
	// root of bst
	Node root=null;
	
	Node inserProcess(Node node,int k){
		if(node==null){
			return node=new Node(k);
		}
		
		if(k< node.key ){
			node.left=inserProcess(node.left,k);	
		}else if(k > node.key){
			node.right=inserProcess(node.right,k);
		}
		return node;
	}
	void insert(int key){
		if(root==null){
			root=new Node(key);
		}else{
			root = inserProcess(root,key);
		}
	}
	
	void inorderStart(){
		inorder(root);
	}
	void inorder(Node node){
		if(node!=null){
			if(node.left!=null){
				inorder(node.left);
			}
			System.out.println(node.key);
			if(node.right!=null){
				inorder(node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data = {2,4,57,3,5,6,7,4};
		BinarySearchTree bst =new BinarySearchTree();
		for(int key : data){
			bst.insert(key);
		}
		
		bst.inorderStart();
	}
	
	
}
