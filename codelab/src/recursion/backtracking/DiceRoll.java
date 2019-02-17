package recursion.backtracking;
import java.util.ArrayList;

/**
 * @author chandrakumar
 *
 Problem : Print all the permutation of dices
 */
public class DiceRoll {

	
	private void diceRollsHelper(int dice,ArrayList<Integer> choosen){
		if(dice==0){
			System.out.println(choosen.toString());
		}else{
			for(int i=1;i<=6;i++){
				choosen.add(i);
				diceRollsHelper(dice-1,choosen);
				choosen.remove(choosen.size()-1);
			}
		}

		
	}
	
	void diceRolls(int dice){
		ArrayList<Integer> choosen = new ArrayList<>();
		diceRollsHelper(dice,choosen);
	}
	public static void main(String[] args) {
		DiceRoll dr  = new DiceRoll();
		dr.diceRolls(3);
	}

}
