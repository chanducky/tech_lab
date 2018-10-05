package algo;

import java.util.Arrays;

public class HeapsAlgorithm {

	private void swap(char[] s,int l,int r){
		char temp = s[l];
		s[l]=s[r];
		s[r]=temp;
	}
	
	private void permute(char[] s,int size){
		if(size==1){
			System.out.println(Arrays.toString(s));
		}
		
		for(int i=0;i<size;i++){
			permute(s,size-1);
			if(size%2==1){
				swap(s,0,size-1);
			}else{
				swap(s,i,size-1);
			}
		}
	}
	
	public static void main(String[] args) {
		HeapsAlgorithm ha = new HeapsAlgorithm();
		
		String line ="1234";
		char[] data = line.toCharArray();
		
		ha.permute(data,data.length);
		
	}

}
