public class Numberof124Country {
	  public static String solution(int n) {
	      String answer = "";
	      int remain;
        
        while (n > 0) {
            remain = n % 3;
            n /= 3;
            
            if (remain == 0) {
                answer = 4 + answer;
                n--;
                continue;
                }
            answer = remain + answer;
            }
	      return answer;
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(solution(1));
		  System.out.println(solution(2));
		  System.out.println(solution(3));
		  System.out.println(solution(4));
		  System.out.println(solution(5));
		  System.out.println(solution(6));
		  System.out.println(solution(7));
		  System.out.println(solution(8));
		  System.out.println(solution(9));
		  System.out.println(solution(10));
	  }
}