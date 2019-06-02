import java.util.HashMap;
import java.util.Map;

public class Country124Seungho {

	public static void main(String[] args) {
		int n = 1;
		String answers = solutions(n);
		System.out.print(answers);
	}
	
	public static String solutions(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String answer = "1";
		int num = 1;
		int count = 0;
		int digits = 0;
		int start = 0; 
		int mid = 0; 
		int end = 0; 
		
		map.put(0, 0);
		while(n > count) {
			count += (int) Math.pow(3, num);
			map.put(num, count);
			num++;
		}
		
		digits = num-1;
		start = map.get(num-2)+1;
		end = map.get(num-1);
		mid = (start + end) / 2;
		
		String convertStart = "";
		String convertMid = "";
		for(int i=1; i<=digits; i++) {
			convertStart += "1";
			convertMid += "2";
		}
		
		int loopStart = 0;
		int loopEnd = 0;
		String loopConvertStart = "";
		
		if(n <= mid) {
			loopStart = start;
			loopEnd = n;
			loopConvertStart = convertStart;
		} else {
			loopStart = mid;
			loopEnd = n;
			loopConvertStart = convertMid;
		}
		char[] chars = loopConvertStart.toCharArray();
		for(int i=loopStart; i<loopEnd; i++) {
			for(int j=chars.length-1; j>=0; j--) {
				if(49 == (int)chars[j]) {
					chars[j] = 50;
					break;
				} else if(50 == (int)chars[j]) {
					chars[j] = 52;
					break;
				} else {
					chars[j] = 49;
				}
			}
		}
		
		answer = new String(chars);
		
		return answer;
	}
}