import java.util.ArrayList;

public class FunctionDevelope {
	
	public static void main(String[] args) {
		int[] progresses = {10, 20, 30};
		int[] speeds = {1, 3, 2};
		int[] answers = solutions(progresses, speeds);
	}
	
	public static int[] solutions(int[] progresses, int[] speeds) {
		int arrLen = progresses.length;
		ArrayList<Integer> workDayList = new ArrayList<Integer>();
		int finishCnt = 1;
		int maxDay = 0;
		
		for(int i=0; i<arrLen; i++) {
			int nextIdx = i+1 == arrLen ? arrLen-1 : i+1;
			int workDay = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);
			int nextWorkDay = (int) Math.ceil((100-progresses[nextIdx])/(double)speeds[nextIdx]);
			if(i == 0) {
				maxDay = workDay;
			}
			if(maxDay < nextWorkDay) {
				maxDay = nextWorkDay;
				workDayList.add(finishCnt);
				finishCnt = 1;
			} else {
				if(i == nextIdx) {
					workDayList.add(finishCnt);
				}
				finishCnt++;
			}
		}
		
		int[] answer = new int[workDayList.size()];
		for(int i = 0; i < workDayList.size(); i++) {
			answer[i] = workDayList.get(i);
		}
		return answer;
	}
}
