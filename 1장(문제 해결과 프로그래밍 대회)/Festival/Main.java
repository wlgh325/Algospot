import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc=1; tc<=T; tc++) {
    		String[] temp = br.readLine().split(" ");
    		int n = Integer.parseInt(temp[0]);
    		int l = Integer.parseInt(temp[1]);
    		
    		int[] cost = new int[n];
    		temp = br.readLine().split(" ");
    		for(int i=0; i<n; i++)
    			cost[i] = Integer.parseInt(temp[i]);
    		
    		double min = Double.MAX_VALUE;
    		
    		// l일부터 n일까지 모두 해본다
    		// i일의 평균을 구한다
    		for(int i=l; i<=n; i++) {
                // 시작위치 = start
    			for(int start =0; start<=n-i; start++) {
                    double sum = 0;
                    // start부터 i개일의 비용의 합을 구합니다.
    				for(int j=start; j<start+i; j++) {
    					sum += cost[j];
    				}
    				double avg = sum / i;   // 평균 구하기
    				min = min > avg ? avg : min;    // 최소값 update
    			}
    		}
    		System.out.println(String.format("%.11f", min));    // 출력
    	}
    }
}