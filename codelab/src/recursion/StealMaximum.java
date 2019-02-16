package recursion;


/** 
 * @author chandrakumar
 *
 Problem Statement : there is home, And thief stole the money but he can not steal the money from two consecutive home but he can skip the home to steal the maximum money. 
 
 Input 1: 1,9,2,4,2,5
 Ouput :  18
 Exaplanation: Thief will steal from home 1,3 and 5 so maximum money = sum(9+4+5)=18
 
 */
class StealMaximum {
	
	static int stealMax(int[] money,int choosen,int sum){
		if(choosen>=money.length){
			return sum;
		}
		
		// next chosen home to steal
		int c1 = stealMax(money,choosen+2,sum+money[choosen]); //when money is stolen then thief can not select next home so next index increased +2
		
		//not stolen from this home so can stole next
		int c2 = stealMax(money,choosen+1,sum); //when money is not stolen then sum will not increase and thief can select consecutive home so index is increased to +1
		
		return Math.max(c1, c2);
		
	}
	
	public static void main(String[] arr){
		// homes with money diff test cases
		int[] money = {1,9,2,4,2,5};
		// int[] money = {1};
		// int[] money = {1,3};
		//int[] money = {1,5,3};
		// int[] money = {10,5,3};
		System.out.println(stealMax(money,0,0));
	}
	

}

           