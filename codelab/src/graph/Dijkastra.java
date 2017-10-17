package graph;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chandra
 *
 */
public class Dijkastra {
    static class Edge {
        int a, b;
        int len;

        public Edge(int a, int b, int len) {
            this.a = a;
            this.b = b;
            this.len = len;
        }
    }
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
    		
        int T = in.nextInt();
        
        for(int i=0; i<T; i++){
        	   
        	   int N = in.nextInt();
           int M = in.nextInt();
        	
            @SuppressWarnings("unchecked")
			ArrayList<Edge>[] edges = new ArrayList[N+1];
            
            for(int k=1; k<=N; k++){
                edges[k] = new ArrayList<>();
            }
            
            for(int j=0; j<M; j++){
                
            	   int a = in.nextInt();
                int b = in.nextInt();
                int l = in.nextInt();
                
                edges[a].add(new Edge(a,b,l));
                edges[b].add(new Edge(b,a,l));
            }
            
            int s = in.nextInt();
            int[] dist = new int[N+1];
            
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[s] = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.add(s);
            
            while(!pq.isEmpty()){
                int k = pq.poll();
                
                for(Edge e: edges[k]){
                    int dis = dist[e.a]+e.len;
                    if(dis<dist[e.b]){
                        dist[e.b] = dis;
                         pq.add(e.b);                            
                    }
                }
            }
            for(int q=1; q<=N; q++){
                if(q==s)
                    continue;
                if(dist[q]==Integer.MAX_VALUE)
                       dist[q]=-1;
                System.out.print(dist[q]);
                System.out.print(" ");
            }
            System.out.println();
            
        }
    }
}
