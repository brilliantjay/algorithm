package programmers_level2_2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class SkillTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[] skill = {"AEF", "CDA", "CBD", "CAE"};
		String[] skill = {"CDA"};
		//String[] skill = {"CDA"};// "CBADF", "AECB", "BDA"};
		//String[] skill = {"BACDE"};
		//String[] skill = {"DBC"};
		
		int result = solution("CBD", skill);
		System.out.println(result);		
	}
	
	 public static int solution(String skill, String[] skill_trees) {
	        String[] skill_arr = skill.split("");	    
	     	      	                
	        int treeSize = skill_trees.length;	         
	        int cnt = 0;         
	        
	        List<String> skill_list = Arrays.asList(skill_arr);
	        
        	for(int i=0;i<treeSize;i++) {
	        	String[] com = skill_trees[i].split("");
	        	HashMap<String,Integer> comMap = new HashMap<String,Integer>();	        	
	        	int comSize= com.length;
	        	boolean parent = true;
	        	
	        	for(int j=0;j<comSize;j++) {
	        		comMap.put(com[j], j);
	        	}     
	        	
	        	int child_idx = -1;
	                	
	        	for(int j=skill_list.size()-1;j>=0;j--) {
	        		String skill_key = skill_list.get(j);
	        		parent = true;	        		
	        		
	        		if(comMap.get(skill_key)==null && child_idx == -1) {
	        			continue;
	        		}
	        		
	        		if(comMap.get(skill_key)==null && child_idx != -1) {
	        			parent=false;
	        			break;
	        		}
	        		
	        		if(child_idx == -1) {
	        			child_idx = comMap.get(skill_key);
	        		}
	        		
	        		int parent_idx = comMap.get(skill_key);
	        		
	        		if(parent_idx > child_idx) {
        				parent=false;
	        			break;
        			}
        				
	        		child_idx = comMap.get(skill_key);       				
	        	}
	        	
	        	if(parent) {
	        		cnt++;
	        	}	
	        	
	        }            
	        	
	        return cnt;
	 }	    

}
