package interview.amazon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



/*
 
 Question : Calculate total no of way to reach from 1 to N where you can move minimum 1 and maximum K time 
 
 */



/**
 * @author Chandra
 *
 */

public class WayToReachN {

	public static long way=0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);

		int T = Integer.parseInt(br.readLine().trim());

		for(int t_i=0; t_i<T; t_i++)
		{
			String[] in=br.readLine().split(" ");
			long N = Long.parseLong(in[0]);
			long K = Long.parseLong(in[1]);
			way=0;
			//long out_ = solve(K, N);
			//System.out.println(out_);
			solve(K, N);
			System.out.println(way);
			System.out.println("");

		}

		wr.close();
		br.close();
	}
	static void  solve(long K, long N){
		jump(K,N,0);    
	}

	static void jump(long K, long N,long t){
		if(t==N){
			++way;
		}else{
			for(long i=1;i<=K;i++){
				if(t+i <=N){
					jump(K,N,t+i);
				}

			}
		}

	}
}