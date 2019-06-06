package nayun;

import java.util.ArrayList;
import java.util.List;

public class StockPriceNayun {
	public static void main(String[] args) {
		//int[] prices = {1,2,3,2,3,1,2,3,2,3,1,2,3,2,3};
		//int[] prices = {1,2,3,2,3};
		//int[] prices = {3,1,1};
		int [] prices = {2,2,1};
		
		int [] answers = solution(prices);
		for(int i=0;i<prices.length;i++) {
			System.out.print(answers[i]+" ");
		}
	}
	
	 public static int[] solution(int[] prices) {
	   
	        List<Integer> answerList = new ArrayList<Integer>();
	        int size = prices.length;
	        
	        for(int i=0;i<size;i++) {	        	
	        	int p = prices[i];
	        	int cnt = 0;        	
	        	
	        	for(int j=i+1;j<size;j++) {
	        		if(p >prices[j]) {
	        			cnt++;
	        			break;
	        		}	        		
	        	
	        		if(p<=prices[j]) {
	        			cnt++;
	        		}
	        	}
	        	
	        	answerList.add(cnt);	        	
	        }
	        
	        return answerList.stream().mapToInt(i->i).toArray();	        
	    }
}
