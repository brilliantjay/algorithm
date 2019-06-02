public class TopSeungho {

	public static void main(String[] args) {
		int[] heights = {3,9,9,3,5,7,2};
		int [] answers = solutions(heights);
		for(int i=0;i<answers.length;i++) {
			System.out.print(answers[i]+" ");
		}
	}
	
	public static int[] solutions(int[] heights) {
		int heightLen = heights.length;
		int[] answer = new int[heightLen];
		for(int i=0; i<heightLen; i++) {
			int prevIdx = i-1;
			while(prevIdx >= 0) {
				if(heights[prevIdx] > heights[i]) {
					answer[i] = prevIdx+1;
					break;
				}
				prevIdx--;
			}
		}
		return answer;
	}
	
}