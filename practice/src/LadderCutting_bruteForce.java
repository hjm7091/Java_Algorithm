import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LadderCutting_bruteForce {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = Integer.parseInt(input.readLine());
		for(int i=0; i<c; i++) {
			int n = Integer.parseInt(input.readLine());
			StringTokenizer st = new StringTokenizer(input.readLine());
			int[] h = new int[n];
			for(int j=0; j<n; j++)
				h[j] = Integer.parseInt(st.nextToken());
			int result = bruteForce(h);
			output.write(result+"\n");
		}
		output.flush();
		output.close();
	}
	
	public static int bruteForce(int[] h) { //판자의 높이를 담은 배열 h[]가 주어질 때 사각형의 최대 너비를 반환
		int ret = 0;
		int N = h.length;
		for(int left=0; left<N; left++) { //가능한 모든 left,right 조합을 순회한다.
			int minHeight = h[left];
			for(int right=left; right<N; right++) {
				minHeight = Integer.min(minHeight, h[right]);
				ret = Integer.max(ret, (right-left+1)*minHeight);
			}
		}
		return ret;
	}

}
