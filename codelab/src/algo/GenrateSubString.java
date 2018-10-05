package algo;

public class GenrateSubString {
	
	public static void main(String[] args) {
		String str = "abcd";
        SubString(str, str.length()); 

	}
	
	public static void SubString(String str, int n) 
    { 
       for (int i = 0; i < n; i++){
    	   for (int j = i+1; j <= n; j++){
    		  String sub =  str.substring(i, j);
    		  System.out.println(sub);
    	   }
       }  
            
                 
    } 
}

