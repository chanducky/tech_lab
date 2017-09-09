package graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



/**
 * @author Chandra
 *
 */
public class ComponentDFS {
    
   static boolean[] visited = null;    
  public  static void  DFS(HashMap<Integer, ArrayList<Integer>> cityMap, Integer k){
            visited[k]=true;
            
        if(cityMap.get(k)!=null){
            for(Integer c : cityMap.get(k)){
                if(! visited[c]){
                    DFS(cityMap, c);    
                }
            }
         } 
      
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
       
        HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();        
            
        for(int a0 = 0; a0 < q; a0++){
             
            int n = in.nextInt();  // no of city//
            int m = in.nextInt();  // no of road
            
            visited = new boolean[n+1];
            cityMap = new HashMap<>(n+1);  
            
            long clib = in.nextLong(); //C cost to build a Lib //
            long croad = in.nextLong();  // cost to build a road //
            
            for(int a1 = 0; a1 < m; a1++){
                Integer city_1 = new Integer(in.nextInt()); // connected to city_2
                Integer city_2 = new Integer(in.nextInt()); // connected to city_1
                
                if(cityMap.containsKey(city_1)){
                    cityMap.get(city_1).add(city_2);
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(city_2);
                    cityMap.put(city_1,list);
                }
                
                
                if(cityMap.containsKey(city_2)){
                    cityMap.get(city_2).add(city_1);
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(city_1);
                    cityMap.put(city_2,list);
                }
                
                
            }
            
            long count=0;
            
            for(Integer key=1;key <=n; key++ ){
               
                if(!visited[key]){
                     ++count;
                  DFS(cityMap, key);  
                }
            } 
             
             System.out.println((count*(clib))+((n-count)*Math.min(clib, croad)));   
         
            
         }
    }
}


          
                   
