import java.util.ArrayList;

public class CrossBridgeTruck {
	
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		int answer = solutions(bridge_length, weight, truck_weights);
		System.out.println("answer: "+answer);
	}
	
	public static int solutions(int bridge_length, int weight, int[] truck_weights) {
		int answer = bridge_length;
		ArrayList<Integer> seconds = new ArrayList<Integer>();
		for(int i=1; i<bridge_length; i++) {
			seconds.add(0);
		}
		for(int j=0; j<truck_weights.length; j++) {
			seconds.add(truck_weights[j]);
		}
		for(int k=0; k<=seconds.size()-bridge_length; k++) {
			int weightSum = 0;
			int innerLen = k+bridge_length-1;
			for(int z=k; z<=innerLen; z++) {
				weightSum += seconds.get(z);
				if(weightSum > weight) {
					seconds.add(z, 0);
				}
			}
		}
		answer = seconds.size()+1;
		
		return answer;
	}
}
