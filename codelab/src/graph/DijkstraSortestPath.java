package graph;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chandra
 *
 */


/*
 * Algorithm : implementation of Dijkstra single source shortest path
 *
 * */

public class DijkstraSortestPath {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new BufferedInputStream(System.in, 65536));
		int t = in.nextInt(); // no of test cases 

		for(int a0 = 0; a0 < t; a0++){

			int n = in.nextInt(); //  no of node in graph
			int m = in.nextInt(); // no of edge in grpah

			Graph graph = new Graph(n, m); // initialize graph
			
			for(int a1 = 0; a1 < m; a1++){
				int x = in.nextInt(); //  edge source node
				int y = in.nextInt(); // edge destination node
				int r = in.nextInt(); //  weight or distance of edge

				graph.addEdge(x,y,r); // add edges
			}

			int s = in.nextInt(); // source node
			
			graph.calculateSortestPath(s);
			graph.printDist();

		}
	}
}

class Graph{

	int v=0; // no of vertices in graph
	int e=0; //  no of edges in graph
	int s=0; // source node
	
	int[] distTo =null;
	int[] pathTo=null;

	HashMap<Integer, ArrayList<Edge>> adjMap = null;

	boolean[] visited =null; 
	PriorityQueue<Edge> queue=null;

	public Graph(int v, int e) {
		super();
		this.v = v;
		this.e = e;

		this.adjMap = new HashMap<>(v);
		this.distTo =new int[v+1];
		this.pathTo=new int[v+1];
		this.visited= new boolean[v+1];
		this.queue = new PriorityQueue<>();

		for(int i=0;i<=v;i++){
			this.distTo[i]=-1; // set every nodes's distance from source as -1
		}

	}

	void addEdge(int x,int y, int r){
		Edge edgeNew = new Edge(x,y,r); 
		ArrayList<Edge> xEdges = this.adjMap.get(x);

		if(xEdges==null){
			xEdges=new ArrayList<>();
			xEdges.add(edgeNew);
		}else{
			boolean found =false;
			for(Edge edge : xEdges){
				if(edgeNew.u==edge.u && edgeNew.v==edge.v){
					found=true;
					if(edgeNew.wt< edge.wt){
						edge.wt = edgeNew.wt;
					}
				}
			}
			if(!found){
				xEdges.add(edgeNew);
			}
		}
		
		this.adjMap.put(x, xEdges);

		ArrayList<Edge> yEdges = this.adjMap.get(y);

		if(yEdges==null){
			yEdges=new ArrayList<>();
			yEdges.add(edgeNew);
		}else{
			boolean found =false;
			for(Edge edge : yEdges){
				if(edgeNew.u==edge.u && edgeNew.v==edge.v){
					found=true;
					if(edgeNew.wt< edge.wt){
						edge.wt = edgeNew.wt;
					}
				}
			}
			if(!found){
				yEdges.add(edgeNew);
			}
		}
		
		this.adjMap.put(y, yEdges);

	}

	void calculateSortestPath(int s){
		this.s=s;
		this.visited[s]=true;
		this.distTo[s]=0;
		
		ArrayList<Edge> pq= this.adjMap.get(s);
		
		if(pq!=null){
			for(Edge edge : pq){
				queue.add(edge);
			}
			
			BFS();
		}

	}

	void BFS(){
		while(! this.queue.isEmpty()){
			Edge edge = queue.poll();

			int dest=0;
			if(! this.visited[edge.u]){
				dest=edge.u;
			}else{
				dest=edge.v;
			}
			
			this.visited[dest] =true;
			
			ArrayList<Edge> neighbours = this.adjMap.get(dest);
			
			for(Edge neighbour : neighbours){
				
				int source = (neighbour.u==dest) ? neighbour.v : neighbour.u;
				
				if(this.visited[source]){
					if(distTo[dest]==-1){
						distTo[dest]= distTo[source]+neighbour.wt;
						pathTo[dest]=source;
						
					}else{
						if((distTo[source]+neighbour.wt) < distTo[dest] ) {
							distTo[dest]=(distTo[source]+neighbour.wt);
							pathTo[dest]=source;
						}   
					}
					
				}else{
					this.queue.add(neighbour);
				}
				
			}
			
		}
	}

	void printDist(){
		for(int i=1; i<=v; i++ ){
			if(i!=s){
				System.out.print(distTo[i]+" ");
			}
		}
        System.out.println("");
	}
	
	class Edge implements Comparable<Edge>{
		int u;
		int v;
		int wt;

		public Edge(int u, int v, int wt) {
			super();
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		public int compareTo(Edge e) {
			return this.wt -e.wt;
		}

	}

}
