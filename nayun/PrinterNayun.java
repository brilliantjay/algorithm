package programmers_level2_2;


import java.util.LinkedList;

import java.util.Queue;


public class PrinterNayun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] priorities = {1,1,9,1,1,1,2,1,3,2};
		//int[] priorities = {2,1,3,2};
		int[] priorities = {1,1,9,1,1,1};
		System.out.println(solution(priorities, 0));		
	}
	
	public static void printSort(LinkedList<QueueIdx> queue, LinkedList<QueueIdx> sample, int first, int last) {
		int len = sample.size();
		
		for(;first<last;first++) {
			QueueIdx sa = sample.get(first);
        	int val1 = sa.queueVal;  
        	int idx = sa.queueIdx;
        	
        	for(int j=first+1;j<len;j++) {
        		QueueIdx sa2 = sample.get(j);
        		int val2 = sa2.queueVal;     		
        		
        		if(val1 < val2) {        			
        			QueueIdx newItem = new QueueIdx();
        			newItem.queueIdx = idx;
        			newItem.queueVal = val1;
                	
        			queue.remove(sa);
                	queue.add(newItem);               	
                	break;
        		}
        	}
        }       
	}
	
	public static void changeArr(LinkedList<QueueIdx> sample ,int len, LinkedList<QueueIdx> queue) {
			
		for(int i=0;i<len;i++) {
			sample.remove();
    	}     	
		
		sample.addAll(queue);
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;       
        
        LinkedList<QueueIdx> queue = new LinkedList<>();  
        LinkedList<QueueIdx> sample = new LinkedList<>();   
        int len = priorities.length;     
        
        for(int i=0;i<len;i++) {
        	QueueIdx idx = new QueueIdx();
        	idx.queueIdx = i;
        	idx.queueVal = priorities[i];
        	queue.add(idx);
        	sample.add(idx);        	
        }       
        
        int first = 0;
        int last = len;
        
        while(true) {
        	
        	printSort(queue, sample, first, last);       	
        	
            boolean checkValid = true;
        	
        	for(int i=0;i<len;i++) {
            	QueueIdx idxI = queue.get(i);
            	int val1 = idxI.getQueueVal();
            	
            	for(int j=i+1;j<len;j++) {
            		QueueIdx idxJ = queue.get(j);
            		int val2 = idxJ.getQueueVal();
            		
            		if(val1 < val2) {
            			checkValid = false;
            			first=i;
            			last = j;
            			break;
            		}            		
            	}
            	
            	if(!checkValid) {
            		changeArr(sample ,len, queue);
            		break;
            	}
            }
        	
        	if(checkValid) {
        		break;
        	}
        }       
        
        int cnt  = 1;
        
        for(QueueIdx queueIdx : queue) {
        	int idx = queueIdx.queueIdx;
        	//int val = queueIdx.queueVal;        	
        	
        	if(idx == location) {
        		answer = cnt; 
        		break;
        	}
        	
        	cnt ++;
        }
        
        return answer;
    }

}

class QueueIdx {
	int queueVal;
	int queueIdx;
	
	public int getQueueVal() {
		return queueVal;
	}
	public void setQueueVal(int queueVal) {
		this.queueVal = queueVal;
	}
	public int getQueueIdx() {
		return queueIdx;
	}
	public void setQueueIdx(int queueIdx) {
		this.queueIdx = queueIdx;
	}	
}
