import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Truck{
		int length;
		int weight;
		
		public Truck(int length, int weight) {
			super();
			this.length = length;
			this.weight = weight;
		}
	}
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        
        Queue<Truck> waitQueue = new LinkedList<>();
        Queue<Truck> runQueue = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++) {
        	waitQueue.offer(new Truck(bridge_length, truck_weights[i]));
        }
        
        totalWeight += waitQueue.peek().weight;
        runQueue.offer(waitQueue.poll());
        answer++;
        
        while(!runQueue.isEmpty()) {
        	for(Truck truck : runQueue) {
        		truck.length--;
        	}
        	
        	if(runQueue.peek().length == 0) {
        		totalWeight -= runQueue.poll().weight;
        	}
        	
        	if(!waitQueue.isEmpty() && waitQueue.peek().weight + totalWeight <= weight) {
        		totalWeight += waitQueue.peek().weight;
        		runQueue.offer(waitQueue.poll());
        	}
        	        	
        	answer++;
        }
        
        return answer;
    }
}