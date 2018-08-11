package codility.Iterations;

import java.util.Scanner;

/**
 * @author chandrakumar
 *
 */
/*
 Problem : Binary Gap
 
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. 
 The number 20 has binary representation 10100 and contains one binary gap of length 1. 
 The number 15 has binary representation 1111 and has no binary gaps. 
 The number 32 has binary representation 100000 and has no binary gaps.
  
 * */

public class BinaryGap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input= sc.nextInt();
		String bin = Integer.toString(input,2);
		
		int MAX_BINARY_GAP=0;
		 int count=0;
		 boolean flag=false;
		 
		for(int i=0;i<bin.length();i++){
			if(bin.charAt(i)=='1'){
				if(!flag){
					flag=true;
				}else{
					if(count > MAX_BINARY_GAP){
						MAX_BINARY_GAP=count;
					}
				}
				count=0;
			}else if(flag) {
				++count;
			}
		}
		
		 System.out.println(MAX_BINARY_GAP);
	}

}
