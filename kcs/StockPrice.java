import java.util.Arrays;

class StockPrice {
    public static int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        int count;

        for (int j = 0; j < prices.length; j++) {
        	count = 0;
        	for (int i = 1; i + j < prices.length; i++) {
        		if (j == j + i) {
        			continue;
        		}
        		if (prices[j] <= prices[j + i]) {
        			count++;
        		}
        		if (prices[j] > prices[j + i]) {
        			count++;
        			break;
        		}
        	}
        	answer[j] = count;
        }

        return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
    }
}
