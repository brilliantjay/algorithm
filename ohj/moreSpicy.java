import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
        	queue.add(scoville[i]);
        }
        
        while(queue.size() >= 2) {
        	int min_1 = queue.poll();
        	int min_2 = queue.poll();
        	
        	if(min_1 > K && min_2 > K) {
        		break;
        	}
        	
        	answer++;
        	
        	int temp = min_1 + (min_2 * 2);
        	queue.add(temp);
        	
        	if(queue.size() == 1 && queue.peek()<K) {
        		answer = -1;
        	}
        }
        
        return answer;
    }
}