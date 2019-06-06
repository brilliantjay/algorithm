package nayun;

import java.util.HashMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class SkillTreeNayun {
    public int solution(String skill, String[] skill_trees) {
         String[] skill_arr = skill.split("");	    
	     	      	                
	        int treeSize = skill_trees.length;	         
	        int cnt = 0;         
	        
	        List<String> skill_list = Arrays.asList(skill_arr);
	        
        	for(int i=0;i<treeSize;i++) {
	        	String[] com = skill_trees[i].split("");
	        	int comSize= com.length;
	        	
	        	HashMap<String,Integer> comMap = new HashMap<String,Integer>();	     	
	        	
	        	for(int j=0;j<comSize;j++) {
	        		comMap.put(com[j], j);
	        	}    
	        	
	        	boolean parent = true;   	 
	        	
	        	int child_idx = comSize;
	                	
	        	for(int j=skill_list.size()-1;j>=0;j--) {
	        		String skill_key = skill_list.get(j);
	        		parent = true;	        		
	        		
	        		if(comMap.get(skill_key)==null && child_idx == comSize) {
	        			continue;
	        		}
	        		
	        		if(comMap.get(skill_key)==null && child_idx != comSize) {
	        			parent=false;
	        			break;
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