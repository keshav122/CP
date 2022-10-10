package October_LongChallenge_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SINGLEOP1 {

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

	public static void main(String[] args) throws IOException {
		FastReader s = new FastReader();
		try {

			int T = s.nextInt();
			while (T-- > 0) {
				int length = s.nextInt();
				String binaryString = s.nextLine();
				boolean isPrinted = false;
				int count = 0;
				for(int i = 0 ; i < binaryString.length();i++) {
					if(binaryString.charAt(i) == '1') {
						count++;
					}else {
						System.out.println(count);
						isPrinted = true;
						break;
					}
					
				}
				if(!isPrinted) {
					System.out.println(count);
				}
				
				
			}

		} catch (Exception e) {
			s.close();
			return;
		}
	}

}
