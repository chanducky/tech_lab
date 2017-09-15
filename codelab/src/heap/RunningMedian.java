package heap;


import java.text.DecimalFormat;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chandra
 *
 */

/*
 Problem Statement : 
 
 Given an input stream of  integers, you must perform the following task for each  integer:

1 : Add the  integer to a running list of integers.
2 : Find the median of the updated list (i.e., for the first element through the  element).
3 : Print the list's updated median on a new line. The printed value must be a double-precision number scaled to decimal place (i.e., 12.3 format).
  
 * */

public class RunningMedian {
	public static void main(String args[] ) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Integer> minHeap  =new PriorityQueue<Integer>();
		PriorityQueue<Integer>  maxheap =new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int i=0;i<N;i++){
			insertAndPrintMedian(minHeap,maxheap, sc.nextInt());
		}
	}

	public static void insertAndPrintMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap , Integer num){
		minHeap.add(num);

		DecimalFormat df = new DecimalFormat("0.0");

		if(minHeap.size() > maxHeap.size()){
			maxHeap.add(minHeap.poll());
		}else if(minHeap.size() == maxHeap.size() && maxHeap.peek() > minHeap.peek() ){
			Integer min = minHeap.poll();
			Integer max = maxHeap.poll();

			maxHeap.add(min);
			minHeap.add(max);
		}

		/* print */

		if(maxHeap.size() > minHeap.size()){
			System.out.println(df.format(maxHeap.peek()));
		}else{
			double d = ( (double)minHeap.peek() + maxHeap.peek() ) /2;
			System.out.println(df.format(d));
		}

	}
}
