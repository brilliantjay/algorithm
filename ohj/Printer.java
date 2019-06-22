import java.util.LinkedList;

class Solution {
    public static class Print {
		public Print(int loc, int num) {
			this.loc = loc;
			this.num = num;
		}
		int loc;
		int num;
	}
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Print> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
        	queue.add( new Print(i, priorities[i]) );
        }
        
        int temp = 0;
        Print tempPrint;
        int count = priorities.length-1;
        
        while(count > 0) {
        	tempPrint = queue.get(temp);
        	
        	for(int i=temp+1; i<priorities.length; i++) {
        		if(tempPrint.num < queue.get(i).num) {
        			queue.add(tempPrint);
        			queue.remove(temp);
        			break;
        		} else if(i == priorities.length-1) {
        			temp++;
        			count--;
        		}
        	}
        }  
        
        for(int i=0; i<queue.size(); i++) {
        	if(location == queue.get(i).loc) {
        		answer = i+1;
        	}
        }
        
        return answer;
    }
}