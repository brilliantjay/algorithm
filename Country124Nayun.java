import java.util.LinkedList;

public class  {
	
	private static int diff = 0;
	private static int cnt = 0;
	private static String str = "";	

	public static void main(String[] args) {
		int[] arr = {13,14,15};
		
		for(int i=0;i<arr.length;i++) {
			cnt = 0;
			System.out.println(solution(arr[i]));
		}
	}	
	
	private static String rePermutation(int[] arr, int r, LinkedList<Integer> rePerArr) {		
        if(rePerArr.size() == r){
            for(int i : rePerArr){               
            	str += i +"";
            }
            
            cnt++;	
            
            if(cnt != diff) {
            	str = "";
            }
            
            return str;
        }
         
        for(int i=0; i<arr.length; i++){  
            rePerArr.add(arr[i]);
            rePermutation(arr, r, rePerArr);
            
            if(cnt == diff) {
            	break;
            }
            
            rePerArr.removeLast();          
        }
        
       return str;
    }
		
	public static String solution(int n) {	
		
		int total = 0;		
		int idx = 1;		
		int subNum = 0;
		int[] arr = {1,2,4};
		LinkedList<Integer> rePerArr = new LinkedList<Integer>();
		
		while(true) {		
			total +=Math.pow(3, idx);
			
			if(total >= n) {
				break;
			}
			
			idx++;
		}		
		
		if(idx > 1) {
			for(int i=1;i<idx;i++) {
				subNum +=Math.pow(3, i);
			}
			
			diff = n - subNum;			
			
			str = rePermutation(arr, idx, rePerArr);					
			
		}else {
			int cnt = 0;
			for(int i=0;i<arr.length;i++) {
				cnt ++;
				if(cnt == n) {
					return String.valueOf(arr[i]);
				}
			}
		}	
		
		return str;
	}

}
