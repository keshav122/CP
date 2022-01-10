package Codechef_JanuaryChallenge_2022_Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PINBS {
    static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		float nextFloat() {
			return Float.parseFloat(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		public void close() throws IOException {
			if (br == null)
				return;
			br.close();
		}
	}

    public static void main (String[] args) throws java.lang.Exception
	{
	   FastReader s = new FastReader();
		int T = s.nextInt();
		try {
			while (T-- > 0) {
				String str = s.nextLine();
				
			     boolean primeFound = false;
				for(int i = 0 ; i < str.length()-1 && !primeFound;i++){
					for(int j = i+1 ; j < str.length() && !primeFound;j++){
						String temp = str.substring(i, j);
						if(isPrime(temp)){
							System.out.println("Yes");
							primeFound = true;
							break;
						}
					}
				}
				if(!primeFound){
					System.out.println("No");
				}
			}
		} catch (Exception e) {
			s.close();
			return;
		}

	}
	
	private static boolean isPrime(String temp) {
		int value = Integer.parseInt(temp, 2);
		if(value == 2 || value == 3){
			return true;
		}
		if((value - 1 ) % 6 == 0 || (value + 1) % 6 == 0) {
			return true;
		}
		return false;
	}
}
