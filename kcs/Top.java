import java.util.Arrays;

public class Top {

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for (int i = heights.length - 1; i >= 0; i--) {
        	for (int j = i; j >= 0; j--) {
        		if (heights[i] < heights[j]) {
        			answer[i] = j + 1;
        			break;
        		}
        	}
        	
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(solution(new int[] {6,9,5,7,4})));  // [0,0,2,2,4]
    	System.out.println(Arrays.toString(solution(new int[] {3,9,9,3,5,7,2}))); // [0,0,0,3,3,3,6]
    	System.out.println(Arrays.toString(solution(new int[] {1,5,3,6,7,6,5}))); // [0,0,2,0,0,5,6]
    }
}