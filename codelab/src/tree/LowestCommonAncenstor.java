package tree;

/**
 * @author chandrakumar
 *
 */

/*
	Problem  statement Lowest common ancestor of Binary Tree between 2 node
 */
public class LowestCommonAncenstor {

/*	private void inorderTraversal(Node node){
		if(node ==null){
			return;
		}else{
			inorderTraversal(node.left);
			System.out.println(node.data);
			inorderTraversal(node.right);
		}
	}
*/


	private Integer lca(Node node,int l,int r){
		Integer left = null;
		Integer right = null;

		if(node.data==l || node.data==r){
			return node.data;
		}
		
		if(node.left!=null){
			left = lca(node.left,l,r);
		}
		if(node.right!=null){
			right = lca(node.right,l,r);
		}
		
		if(left!=null && right!=null){
			return node.data;
		}else if(left!=null){
			return left;
		}else if(right!=null){
			return right;
		}
		
		return null;
		
	}


	public static void main(String[] args) {

		Node root = new Node(3);

		root.left = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(11);

		root.left.right.left = new Node(9);
		root.left.right.right = new Node(5);

		root.right = new Node(8);
		root.right.right = new Node(13);
		root.right.right.left = new Node(7);
		

		LowestCommonAncenstor lca =  new LowestCommonAncenstor();
		//lca.inorderTraversal(root);
		Integer data = lca.lca(root, 9, 2);

		System.out.println(data);
	}

}

class Node{
	Node left,right;
	int data;

	public Node(int data) {
		super();
		this.data = data;
	}

}
