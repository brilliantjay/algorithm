import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
  int len = scoville.length;
		int answer = 0;
		if(len == 1 && scoville[0] >= K) {
			return 0;
		}else if(len == 1 && scoville[0] < K) {
			return -1;			
		}else {	
			Queue<Integer> queue = new PriorityQueue<>(len, new ComPrio());
		 
			for(int i=0;i<len;i++) {
				queue.add(scoville[i]);
			}	
			
			while(true) {
				int first = queue.poll();				
				
				if(first >= K) {
					break;
				}
				
				if(queue.size() == 0 && first < K) {
					answer = -1;
					break;
				}
				
				int last = queue.poll();
				
				int result = first + (last*2);			
				
				queue.add(result);
				answer ++;			
			}
			
		    return answer;
	   }
	}
 }

class ComPrio implements Comparator<Integer>{

	@Override
	public int compare(Integer idx1, Integer idx2) {
		// TODO Auto-generated method stub	
		return idx1 - idx2;
	}	
}
