class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i=heights.length-1; i>=0; i--) {
        	int tempNum = heights[i];
        	
        	for(int j=i-1; j>=0; j--) {
        		if(heights[j] > tempNum) {
        			answer[i] = j+1;
        			break;
        		} else if(j==0) {
        			answer[i] = 0;
        		}
        	}
        }
        return answer;
    }
}