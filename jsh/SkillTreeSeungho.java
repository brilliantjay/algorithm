public class SkillTreeSeungho {
	public static void main(String[] args) {
		String skill = "CBDFGWE";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CFGEWAD", "CDBP", "CZBZDZFZGZWZEZ"};
		solutions(skill, skill_trees);
	}
	
	public static int solutions(String skill, String[] skill_trees) {
		char[] skills = skill.toCharArray();
        int cnt = 0;
        for(String i : skill_trees) {
            boolean flag = true;
            for(int j=0; j<skills.length; j++) {
                if(flag) {
                    for(int k=j+1; k < skills.length; k++) {
                        // 선행 스킬이 없고 후행스킬이 있을 때
                        if(i.indexOf(skills[j]) == -1 && i.indexOf(skills[k]) > -1) {
                            flag = false;
                            break;
                        // 선행 스킬 이후 후행스킬 없을 때
                         } else if(i.indexOf(skills[j]) > -1 && i.indexOf(skills[k]) == -1) {
                             continue;
                         // 선행 후행 둘다 있을 때
                         } else {
                             // 선행 이전에 후행스킬이 있을 때
                             if(i.lastIndexOf(skills[j]) > i.indexOf(skills[k])) {
                                flag = false;
                                break;
                            }
                         }
                    }
                }
            }
            if(flag) {
                cnt++;
                System.out.println(i);
            }
        }
        return cnt;
	}
}
