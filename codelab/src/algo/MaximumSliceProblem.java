package algo;

class MaximumSliceProblem {
   public static void main(String[] args){
	   
	   int[] arr = {5,-7,3,5,-2,4,-1};
	   
	   int max_ending = 0, max_slice = 0;
	   
	   for(int a:arr){
		   max_ending = Math.max(0, max_ending + a);
		   max_slice =  Math.max(max_slice, max_ending);
	   }
	   
	   System.out.println(max_slice);
   }
    
}