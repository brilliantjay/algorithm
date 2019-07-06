﻿class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
        	if(i == prices.length-1) {
        		answer[i] = 0;
        	} else {
        		int tempCount = 0;
        		for(int j=i+1; j<prices.length; j++) {
        			tempCount++;
        			if(prices[i] > prices[j]) {
        				break;
        			}
        		}
        		answer[i] = tempCount;
        	}
        }
        
        return answer;
    }
}