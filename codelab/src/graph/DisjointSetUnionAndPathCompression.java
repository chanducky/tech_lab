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
 Algo : Disjoint set -Union By Rank and Path Compression
 * */

public class DisjointSetUnionAndPathCompression {

	final int N;  // no of node
	int[] parent;
	int[] rank;
	
	public DisjointSetUnionAndPathCompression(int n) {
		super();
		N = n;
		this.parent = new int[n+1];
		this.rank = new int[n+1];
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

		if(rank[root_a] < rank[root_b]){
			this.parent[root_a] =root_b;
		}else if(rank[root_b]< rank[root_a]){
			this.parent[root_b]=root_a;
		}else{
			this.parent[root_b]=root_a;
			this.rank[root_a]= this.rank[root_a]+1;
		}
		
		
	}

	void init(){
		for(int i=1; i<= this.N; i++){
			this.parent[i]=i;
			this.rank[i]=0;
		}
	}

	public static void main(String[] args) {

		HashMap<Integer, Set<Integer>>  disSet =new HashMap<>();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // no of nodes
		int M = sc.nextInt(); // no of pairs

		DisjointSetUnionAndPathCompression ds = new DisjointSetUnionAndPathCompression(N);

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
