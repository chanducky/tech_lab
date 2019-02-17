package recursion.backtracking;

/**
 * @author chandrakumar
 *
 */
public class PermutaionGenerator {

	public static void main(String[] args) {
		String input = "abcd";
		PermutaionGenerator pg = new PermutaionGenerator();
		pg.permute(input);
	}
	
	void permute(String input){
		permuteHelper(new StringBuilder(),new StringBuilder(input));
	}
	
	private void permuteHelper(StringBuilder choosen,StringBuilder available){
		if(available.length()==0){
			System.out.println(choosen);
		}else{
			for(int i=0;i<available.length();i++){
				//choose
				char c = available.charAt(i);
				choosen.append(c);
				available.deleteCharAt(i);
				
				//explore
				permuteHelper(choosen,available);
				
				//un-choose
				choosen.deleteCharAt(choosen.length()-1);
				available.insert(i, c);
				
			}
		}
	}
}
