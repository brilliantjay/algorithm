import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
      int answer = 0;
		String[] arr = arrangement.split("");
		
		Stack<Integer> stack = new Stack();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(")")) {
				int idx = stack.pop();
				map.put(idx, i);
			}else {			
				stack.add(i);
			}
		}	
		
		Iterator iter = map.keySet().iterator();	
		
		while(iter.hasNext()) {
			int idx = (int) iter.next();			
			int val = map.get(idx);	
			
			if(val == idx+1) {
				continue;
			}		
			
			for(int i=idx;i<=val;i++) {
				String first = arr[i];
				
				if(first.equals("(")) {
					if(i+1 <=val) {
						String last = arr[i+1];
						if(last.equals(")")){
							answer++;
						}
					}
				}
			}
			
			answer+=1;
		}
        
        return answer;
    }
}
