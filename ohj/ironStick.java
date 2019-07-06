import java.util.Stack;
class Solution {
    public static int solution(String arrangement) {
        int answer = 0;
        
        char[] array = arrangement.toCharArray();
        Stack<Character> stack = new Stack<>();
        int stackCount = 0;
        
        for(int i=0; i<array.length; i++) {
        	if(array[i] == '(') {
        		if(!stack.isEmpty() && array[i-1] == '(') {
        			stackCount++;
        		}
        		stack.push(array[i]);
        	} else {
        		stack.pop();
        		if(array[i-1] == ')') {
        			stackCount--;
        			answer++;
        		}else {
        			answer += stackCount;
        		}
        	}
        }
        
        return answer;
    }
}