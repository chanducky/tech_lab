package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Chandra
 *
 */

/*
 Algo : Union-Find Algorithm
 * */

public class DisjointSets {

	final int N;  // no of node
	int[] parent;

	public DisjointSets(int n) {
		super();
		N = n;
		this.parent = new int[n+1];
	}

	int find(int n){
		while(parent[n] !=n){
			n = parent[n];
		}
		return n;
	}

	void unioin(int a, int b){
		int root_a = this.find(a);
		int root_b = this.find(b);

		if(root_a > root_b){
			this.parent[b]=root_a;
		}else{
			this.parent[a]=root_b;
		}
	}

	void init(){
		for(int i=1; i<= this.N; i++){
			this.parent[i]=i;
		}
	}

	public static void main(String[] args) {

		HashMap<Integer, Set<Integer>>  disSet =new HashMap<>();

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // no of nodes
		int M = sc.nextInt(); // no of pairs

		DisjointSets ds = new DisjointSets(N);

		ds.init();

		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			ds.unioin(a, b);
		}

		for(int i=1;i<=N;i++){
			int root =	ds.find(i);
			if(disSet.containsKey(root)){
				Set<Integer> s = disSet.get(root);
				s.add(i);
				disSet.put(root, s);
			}else{
				Set<Integer> s = new HashSet<>();
				s.add(i);
				disSet.put(root, s);
			}

		}
		
		System.out.println(" sets =  " + disSet.toString());

	}

}
