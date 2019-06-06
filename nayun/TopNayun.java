package nayun;

class TopNayun {
    public int[] solution(int[] heights) {
       int[] answer = new int[heights.length];
		
		for(int i=heights.length-1;i>=0;i--) {
			int top = heights[i];
			boolean check = false;
			for(int j=i-1;j>=0;j--) {
				if(heights[j]>top) {
					answer[i] = j+1;
					check = true;
					break;
				}
			}
			
			if(!check) {
				answer[i]=0;
			}
			
		}
        
        return answer;
    }
}
