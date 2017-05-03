import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
 
class FredoLargeNUmber {
 
	public static void main(String[] args) throws IOException {
	
		Reader in = new Reader();
		
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		long t;
		long j=1;
		long max_freq=0;
		LinkedHashMap<Long,Long> lastHash = new LinkedHashMap<Long,Long>();
		LinkedHashMap<Long,Long> ll = new LinkedHashMap<Long,Long>();
		LinkedHashMap<Long,Long> firstHash = new LinkedHashMap<Long,Long>();
		for(int i=0;i<n;i++){
			t=in.nextLong();
			if (lastHash.containsKey(t))
				lastHash.put(t, lastHash.get(t)+1);
			else 
				lastHash.put(t, (long) 1);
		}
 
	
		for (Entry<Long, Long> entry : lastHash.entrySet()) {
			if (ll.containsKey(entry.getValue()))
				continue;
			else {
				ll.put(entry.getValue(), entry.getKey());
				}
			while(j<=entry.getValue()) {
				firstHash.put(j, entry.getKey());
					j++;
				}
			}
		
		max_freq = j-1;
	
				
		int q = in.nextInt();
		for(int i=0;i<q;i++) {
			int a =in.nextInt();
			long b =in.nextLong();
			if (b>max_freq) {
				out.println("0");
				continue;
			}
			boolean flag=false;
			if (a==1) {
					if (ll.containsKey(b)) {
					
						out.println(ll.get(b));
						flag = true;
					}
				
			}
			else {
				if (firstHash.containsKey(b)) {
							out.println(firstHash.get(b));
							flag = true;
					}
		}
			
			if(!flag) 
				out.println("0");
			}			
		out.close();
	}
 
 
	static class Reader{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader(){
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException{
			byte[] buf = new byte[512]; 
			int cnt = 0, c;
			while ((c = read()) != -1){
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
 
		public int nextInt() throws IOException{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do{
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
 
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
 
			if (c == '.'){
				while ((c = read()) >= '0' && c <= '9'){
					ret += (c - '0') / (div *= 10);
				}
			}
			
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException{
			if (din == null)
				return;
			din.close();
		}
	}
}
}
}
