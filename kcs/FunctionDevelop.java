import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelop {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        List<Integer> c = new ArrayList<Integer>();
        int[] result = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            while (progresses[i] / 100 < 1) {
                progresses[i] = progresses[i] + speeds[i];
                count++;
            }
            result[i] = count;
        }
            
            int count = 0;
            for (int i = 0, base = result[i]; i < result.length; i++) {
                if (base >= result[i])
                    count++;
                else {
                    base = result[i];
                    c.add(count);
                    count = 1;
                }
                if (i == result.length - 1)
                    c.add(count);
            }
            answer = c.stream().mapToInt(i->i).toArray();
        return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(solution(new int[] {93,30,55}, new int[] {1,30,5})));
    }
}
