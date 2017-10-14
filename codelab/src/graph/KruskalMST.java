package graph;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chandra
 *
 */

/*
Algo : Disjoint set -KRUSKAL MST

 */

public class KruskalMST {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt(); // no of nodes in graph
		int E= sc.nextInt(); // no of edge

		DisjoinSet ds =new DisjoinSet(N);
		PriorityQueue<Edge> pq =new PriorityQueue<>();

		for(int i=0;i<E;i++){
			int u =sc.nextInt();
			int v =sc.nextInt();
			int wt = sc.nextInt();

			Edge edge =new Edge(u,v,wt);
			pq.add(edge);

			ds.init();

		}

		int mstWt = 0;
		while(! pq.isEmpty()){
			Edge e = pq.poll();

			if(! ds.isCyle(e.u, e.v)){
				ds.unioin(e.u, e.v);
				mstWt=mstWt+e.wt;
			}
		}

		System.out.println(mstWt);
	}

}

class Edge implements Comparable<Edge> {
	int u;
	int v;
	int wt;

	public Edge(int u, int v, int wt) {
		super();
		this.u = u;
		this.v = v;
		this.wt = wt;
	}

	@Override
	public int compareTo(Edge e) {
		return this.wt -e.wt;
	}

	@Override
	public String toString() {
		return "Edge [u=" + u + ", v=" + v + ", wt=" + wt + "]";
	}

}

class DisjoinSet {

	final int N;  // no of node
	int[] parent;
	int[] rank;

	public DisjoinSet(int n) {
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

	boolean isCyle(int s, int d){
		int root_s = this.find(s);
		int root_d = this.find(d);

		if(root_s == root_d){
			return true;
		}
		return false;
	}
}