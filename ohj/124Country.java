import java.util.ArrayList;
import java.util.List;

class Solution {
    		public static int numCal(ArrayList<Integer> sumArray, int value) {
		int temp = (value - sumArray.get(sumArray.size()-2));
		return (int)(Math.ceil(temp/(Math.pow(3, sumArray.size()-1))));
	}
		public static String solution(int n) {
		String answer = "";
		int[] base = {1,2,4};
		ArrayList<Integer>sumArray = new ArrayList<>();
		
		while(true) {
			int powNum = (int)Math.pow(base.length, sumArray.size()+1);
			if(sumArray.size() == 0) {
				sumArray.add(powNum);
			} else if(n > sumArray.get(sumArray.size()-1)) {
				sumArray.add(sumArray.get(sumArray.size()-1) + powNum);
			} else {
				break;
			}
		}

		while(true) {
			if(sumArray.size() == 1) {
				answer = new StringBuilder(answer).append(base[n-1]).toString();
				break;
			} else {
				int numCal = numCal(sumArray, n);
				answer = new StringBuilder(answer).append(base[numCal-1]).toString();
				n -= (numCal*Math.pow(base.length, sumArray.size()-1));
				sumArray.remove(sumArray.size()-1);
			}
		}
	       
		return answer;
	}
}