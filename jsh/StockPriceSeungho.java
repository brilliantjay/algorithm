public class StockPriceSeungho {

	public static void main(String[] args) {
		int[] prices = {2, 2, 1};
		int [] answers = solutions(prices);
		for(int i=0;i<answers.length;i++) {
			System.out.print(answers[i]+" ");
		}
	}
	
	public static int[] solutions(int[] prices) {
		int pricesLen = prices.length;
		int[] answer = new int[pricesLen];
		for(int i=0; i<pricesLen; i++) {
			int seconds = 0;
			for(int j=i+1; j<pricesLen; j++) {
				seconds++;
				if(prices[j] < prices[i]) {
					break;
				}
			}
			answer[i] = seconds;
		}
		return answer;
	}
	
}