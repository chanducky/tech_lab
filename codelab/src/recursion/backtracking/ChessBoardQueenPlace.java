package recursion.backtracking;

import java.util.Scanner;

/**
 * @author chandrakumar
 *
 Problem Statement : How to place N queen at board of N*N so they don't cross each other 
 
 */
public class ChessBoardQueenPlace {

	static int[][] board;
	static int bs=0;
	
	static void board(int n){
		board= new int[n][n];
	}
	
	static void printBoard(){
		for(int i=0;i<board.length;i++){
			System.out.println(" ");
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+" ");
			}
		}
		System.out.println();
	}
	
	static boolean isSafeDigonal(int row,int col){
		int range = board.length-1;
		
		int r1 = row- Math.min(row, col);
		int c1 = col- Math.min(row, col);
		
		while(r1<=range && c1<=range){
			//System.out.println(" " + r1 +" "+c1);
			
			if(board[r1][c1]==1){
				return false;
			}
			++r1;
			++c1;
		}
		
		// System.out.println("------------ ");
		
		int r2 = (row+col) >range ? range : row+col;
		int c2 = (row+col) >range ? (row+col)-range:0;
		while(r2>=0 && c2<=range){
			//System.out.println(" " + r2 +" "+c2);
			
			if(board[r2][c2]==1){
				return false;
			}
			--r2;
			++c2;
		}
		
		return true;
		
	}
	
	static boolean isSafe(int row, int col){
		
		// traverse whole cols
		for(int i=0;i<board.length;i++){
			if(board[i][col]!=0){
				return false;
			}
		}
		
		// traverse whole row
		for(int j=0;j<board.length;j++){
			if(board[row][j]!=0){
				return false;
			}
		}		
		
		
		
		return true;
	}
	
	static void placeQueen(int col){
		if(col>=board.length){
			
			printBoard();
			System.out.println();
			
		}else{
			for(int row=0;row<board.length;row++){
				if(isSafe(row,col) && isSafeDigonal(row,col)){
					//choose					
					board[row][col]=1;
					//explore
					placeQueen(col+1);
					//un-choose
					board[row][col]=0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int boardSize = scan.nextInt();
		board(boardSize);
		
		
		// board(8);
		printBoard();
		placeQueen(0);
		
		
	}

}
