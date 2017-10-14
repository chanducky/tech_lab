package graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author Chandra
 *
 */
public class SortestPathBFS {
	@SuppressWarnings("rawtypes")
	static ArrayList[] adjList = null;
	static boolean[] visited = null;    
	static LinkedHashMap<Integer,Integer> distMap = null;
	static Queue<Integer> queue = null;
	static int source=0;

	static void setMinPath(int v){}
	@SuppressWarnings("unchecked")
	static void BFS(){
		while(!queue.isEmpty()){
			Integer v = queue.poll();  
			if(!visited[v]){
				visited[v]=true;

				if(adjList[v]!=null){
					ArrayList<Integer> temp =  adjList[v];  
					for(Integer d : temp){
						if(visited[d]){
							if(distMap.get(v)!= -1){
								if((distMap.get(d)+6) < distMap.get(v).intValue() ){
									distMap.put(v, distMap.get(d)+6); 
								}
							}else{
								distMap.put(v, distMap.get(d)+6);        
							}
						}else{
							queue.add(d);	
						}
					} 
				}
			}
		}    

	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int m = in.nextInt();

			adjList = new ArrayList[n+1];
			distMap = new LinkedHashMap<Integer,Integer>(n);
			queue = new LinkedList<Integer>();
			visited=new boolean[n+1];

			for(int i=1;i<=n;i++){
				distMap.put(i,-1);
			}

			for(int a1 = 0; a1 < m; a1++){
				int u = in.nextInt();
				int v = in.nextInt();

				if(adjList[u]!=null){
					adjList[u].add(v);
				}else{
					adjList[u]=new ArrayList<Integer>();
					adjList[u].add(v);
				}

				if(adjList[v]!=null){
					adjList[v].add(u);
				}else{
					adjList[v]=new ArrayList<Integer>();
					adjList[v].add(u);
				}
			}

			int s = in.nextInt();
			queue.add(s);
			visited[s]=true;
			distMap.put(s,0);
			
            ArrayList<Integer> temp =  adjList[s];
             if(temp!=null ){
            	 for(Integer  a: temp){
                     queue.add(a);
                 }
            }
			
            BFS();

			for(Entry<Integer,Integer> entry : distMap.entrySet()){
				if(entry.getValue() != 0){
					System.out.print(entry.getValue()+" ");    
				}
			}
			System.out.println();
			
		}
		in.close();
	}
}