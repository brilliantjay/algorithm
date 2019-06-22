import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruckNayun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {10};
		//int[] weights = {10,10,10,10,10,10,10,10,10,10};
		//int[] weights = {9, 9, 9, 8, 7, 7, 7, 4, 3, 3, 2};
		//int[] weights = {7,4,5,6};
		System.out.println(solution(100,100,weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		   int i = 0;		 
		   int time = 0;
		   int totalWeight = 0;
		   int index = 0;
		   Queue<Integer> truckQueue = new LinkedList<Integer>();
		   Queue<Integer> enterTimeQueue = new LinkedList<Integer>();
		   int truckLen = truck_weights.length;		   
		   
		   while(true) {			   	   
			   time ++;		     
			   
			   if(enterTimeQueue.size() > 0) {
				   int enterTime = enterTimeQueue.peek();
				   if(time - enterTime == bridge_length) {				 
					   enterTimeQueue.poll();
					   int truck = truckQueue.poll();
					   
					   if(totalWeight > weight) {
						   totalWeight = 0;
						   i = index;
					   }else {
						   totalWeight-= truck;
					   }
				   }
			   }
			   
			   if(i<=truckLen-1) {			     			       		
				   int truck = truck_weights[i];
				   totalWeight+=truck;
				   
				   if(totalWeight > weight) {
					   index = i;
					   i = truckLen;					   
				   }else {					   
					   enterTimeQueue.offer(time);
					   truckQueue.offer(truck);
					   i++;
				   }
			    }			
			   
			   if(enterTimeQueue.size() == 0 && i == truckLen) {
				   break;
			   }   
			   
		   }
		
		   return time;
	    }

}
