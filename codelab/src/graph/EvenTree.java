package graph;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Chandra
 *
 */

/*
 * 
 Problem Statement : 
 
 You are given a tree (a simple connected graph with no cycles). The tree has  nodes numbered from  to  and is rooted at node .

 Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of nodes.
 
 * */

public class EvenTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		HashMap<Integer, Node> nodeMap = new HashMap<>(N+1);
		
		for(int i=1;i<=N;i++){
			nodeMap.put(i,new Node());
		}
		
		for(int i=1;i<=M; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			Node child =  nodeMap.get(u);
			child.parent=nodeMap.get(v);
			Node parent =child.parent;
			
			while (parent!=null){
				parent.chilrens++;
				parent = parent.parent;
				
			}
			
		}

		int disconnect=-1;
		
		for(int i=1;i<=N;i++){
			Node node =nodeMap.get(i);
			
			if(node.chilrens %2==1){
				++disconnect;
			}
		}
		
		System.out.println(disconnect);
	}

}


class Node{
	int chilrens=0;
	Node parent;
}
