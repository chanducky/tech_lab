package recursion;

/**
 * @author chandrakumar
 *
 */
// Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
public class SumOfSubSet {
	int set[] = {3, 34, 4, 12, 5, 2, 1};
	int L=set.length;
	int sumRequired=9;

	private void sosHelper(int level,int sumUsed, String series){
		if(sumUsed>sumRequired){
			// do nothing
		}else if(sumUsed==sumRequired){
			System.out.println(series);
		}else{
			if(level+1 <L){
				sosHelper(1+level,sumUsed+set[1+level],series+" "+set[1+level]);
				sosHelper(1+level,sumUsed,series);
			}
		}
	}
	private void sos(){
		sosHelper(0,set[0],"3");
		sosHelper(0,0,"");
		
	}
	public static void main(String[] arr){
		SumOfSubSet sos = new SumOfSubSet();
		sos.sos();
	}
}

