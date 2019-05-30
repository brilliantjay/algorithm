class SkillTree {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] temp_skill_trees = new String[skill_trees.length];

        for (int i = 0; i < skill_trees.length; i++) {
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (j == 0)
                    temp_skill_trees[i] = "";
                if (skill.contains("" + skill_trees[i].charAt(j))) {
                    temp_skill_trees[i] += skill_trees[i].charAt(j);
                  }
                }
              }

        for (int i = 0; i < temp_skill_trees.length; i++) {
            if (temp_skill_trees[i].length() == 0) {
                answer++;
                continue;
                }
            if (skill.contains(temp_skill_trees[i]) && temp_skill_trees[i].charAt(0) == skill.charAt(0)) {
                answer++;
              }
            }
        return answer;
        }
    
    public static void main(String[] args) {
    	System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }

}
