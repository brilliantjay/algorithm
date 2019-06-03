import java.util.Arrays;

public class CrossBridgeTruck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total = 0, count = 0;
        int[] lengths = new int[truck_weights.length];
        
        for (int i = 0; i < truck_weights.length; i++) {
            if (total + truck_weights[i] > weight) {
                total = truck_weights[i];
                lengths[i] = bridge_length;
            }
            else {
                total += truck_weights[i];
                if (count > 0) {
                    lengths[i - 1] = 0;
                }
                lengths[i] = bridge_length + count;
                count++;
            }
        }
        System.out.println(Arrays.toString(lengths));
        for (int i = 0; i < lengths.length; i++)
            answer += lengths[i];
        answer++;
        return answer;
    }
    
    public static void main(String[] args) {
//    	System.out.println(solution(2, 10, new int[] {7,4,5,6})); // 8
//    	System.out.println(solution(2, 10, new int[] {7,10,5,6})); // 9
    	System.out.println(solution(2, 10, new int[] {5,5,5,5})); // 6
//    	System.out.println(solution(100, 100, new int[] {10})); // 101
    	System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110
    }
}