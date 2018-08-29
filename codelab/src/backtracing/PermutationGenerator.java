package backtracing;


/**
 * @author chandrakumar
 *
 */

// Problem statement  : Generate Permutation of a string using backtracking.
public class PermutationGenerator
{
	public String swap(String s, int i,int j){
		char[] charArr = s.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j]=temp;
		return String.valueOf(charArr);
	}

	public void permute(String s,int l, int r){
		if(l==r){
			System.out.println(s);
		}else{
			for(int i=l;i<=r;i++){
				s = swap(s,i,l);
				permute(s,l+1,r);
				s = swap(s,i,r);
			}
		}
	}
	public static void main(String[] arr){
		String line = "ABC";
		
		PermutationGenerator pg = new PermutationGenerator();
		pg.permute(line, 0, line.length()-1);
	}
}

