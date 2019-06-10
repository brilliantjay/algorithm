import java.util.ArrayList;

class Solution {
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int[] tempArray = new int[progresses.length];
		
		ArrayList<Integer> tempList = new ArrayList<>();
		
		for(int i=0; i<tempArray.length; i++) {
			int tempValue = 100 - progresses[i];
			tempArray[i] = (int)(Math.ceil((double)tempValue/speeds[i]));
		}
		
		int tempMax = 0;
		int tempCount = 0;
		
		for(int i=0; i<tempArray.length; i++) {
			if(i == 0) {
				tempMax = tempArray[i];
			}
			
			if(tempArray[i] <= tempMax) {
				tempCount++;
			} else {
				tempList.add(tempCount);
				tempCount = 1;
				tempMax = tempArray[i];
			}
			if(i == tempArray.length-1) {
				tempList.add(tempCount);
			}
		}
		
		answer = new int[tempList.size()];
		for(int i=0; i<tempList.size(); i++) {
			answer[i] = tempList.get(i);
		}
		
		return answer;
	}
}