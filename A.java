package Round758;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Codeforces Round758
public class A {

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64];// line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		try {
			int T = s.nextInt();
			while (T-- > 0) {
				int n = s.nextInt();
				StringBuilder sb = new StringBuilder();
				if(n == 1){
					sb.append(1);
					System.out.println(sb.toString());
					continue;
				}
				List<Integer> li = primeNumbersList((int) Math.pow(n, 2), n);
				for (int i = 0; i < n-1;i++) {
					sb.append(li.get(i));
					sb.append(" ");
				}
				sb.append(li.get(n-1));
				System.out.println(sb.toString());
			}
		} catch (Exception e) {
			s.close();
			return;
		}
	}

	private static List<Integer> primeNumbersList(int n, int req) {
		List<Integer> ans = new ArrayList<>();
		boolean primeArr[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			primeArr[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {
			if (primeArr[i] == true) {
				for (int j = i * i; j <= n; j += i)
					primeArr[j] = false;
			}
		}

		for (int i = 2; i <= n && ans.size() <= req; i++) {
			if (primeArr[i] == true)
				ans.add(i);
		}

		return ans;
	}
}
