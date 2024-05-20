package csen1002.main.task6;

import java.util.*;

/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

public class CfgFirstFollow {

	/**
	 * Constructs a Context Free Grammar
	 *
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	String variablesSemiColon;
	String Variables[];
	String terminalsSemiColon;
	String terminals [];
	String rules[];
	HashMap<String, List<String>> rulesMap = new HashMap<String, List<String>>();
	HashMap<String, List<Character>> firstMap = new HashMap<String, List<Character>>();
	HashMap<String, List<Character>> followMap = new HashMap<String, List<Character>>();
	public CfgFirstFollow(String cfg) {
		// TODO Auto-generated constructor stub
		String[] split = cfg.split("#");
		variablesSemiColon = split[0];
		Variables = split[0].split(";");
		terminalsSemiColon = split[1];
		terminals = split[1].split(";");
		rules = split[2].split(";");
		populateRulesMap();
	}
	private void populateRulesMap() {
		for (String rule : rules) {
			String[] split = rule.split("/");
			if (rulesMap.containsKey(split[0])) {
				List<String> oldRules = rulesMap.get(split[0]);
				String[] splitRules = split[1].split(",");
				oldRules.addAll(Arrays.asList(splitRules));
				rulesMap.put(split[0], oldRules);
			} else {
				List<String> newRules = new ArrayList<>();
				String[] splitRules = split[1].split(",");
				newRules.addAll(Arrays.asList(splitRules));
				rulesMap.put(split[0], newRules);
			}
		}
	}

	/**
	 * Calculates the First Set of each variable in the CFG.
	 *
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String first() {
		// TODO Auto-generated method stub
		for (String terminal : terminals) {
			List<Character> first = new ArrayList<>();
			first.add(terminal.charAt(0));
			firstMap.put(terminal, first);
		}
		for(String variable : Variables) {
			List<Character> first = new ArrayList<>();
			firstMap.put(variable , first);
		}
		boolean change=true;
		while(change) {
			change = false;
			for (String variable : Variables) {
				List<Character> first = firstMap.get(variable);
				for (String rule : rulesMap.get(variable)) {
					boolean intersectionEpsilon = true;
					for (int i = 0; i < rule.length(); i++) {
						//System.out.println(rule + firstMap);
						if (rule.charAt(i)!='e') {
							if (!firstMap.get(rule.charAt(i) + "").contains('e')) {
								intersectionEpsilon = false;
							}
						}
					}
					if (intersectionEpsilon && !first.contains('e')) {
						first.add('e');
						change = true;
					}
					for (int i=0 ; i<rule.length();i++){
						boolean intersectionEpsilon2 = true;
						for(int j=0;j<i;j++){
							if(!firstMap.get(rule.charAt(j)+"").contains('e')){
								intersectionEpsilon2 = false;
							}
						}
						if(intersectionEpsilon2 && rule.charAt(i)!='e'){
							for(Character c : firstMap.get(rule.charAt(i)+"")){
								if(!first.contains(c) && c!='e'){
									first.add(c);
									change = true;
								}
							}
						}
					}
				}
				Collections.sort(first);
				firstMap.put(variable, first);
			}

		}
		String result = "";
		for(String variable : Variables){
			result += variable + "/";
			for(Character c : firstMap.get(variable)){
				result += c;
			}
			result += ";";
		}
		return result.substring(0, result.length()-1);
	}

	/**
	 * Calculates the Follow Set of each variable in the CFG.
	 *
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		first();
		for (String variable : Variables) {
			List<Character> follow = new ArrayList<>();
			if (variable.equals(Variables[0])) {
				follow.add('$');
			}
			followMap.put(variable, follow);
		}
		boolean change = true;
		while(change){
			change=false;
			for (String rule  :  rules) {
				String[] split = rule.split("/");
				String[] singleRules = split[1].split(",");
				for (int i = 0; i < singleRules.length; i++) {
					String singleRule = singleRules[i];
					for (int j = 0; j < singleRule.length(); j++) {
						if (Arrays.toString(Variables).contains(singleRule.charAt(j) + "")) {
							List<Character> follow = followMap.get(singleRule.charAt(j)+"");
							for (int k = j + 1; k < singleRule.length(); k++) {
								boolean intersectionEpsilon = true;
								for (int l = j + 1; l < k; l++) {
									if (!firstMap.get(singleRule.charAt(l) + "").contains('e')) {
										intersectionEpsilon = false;
									}
								}
								if (intersectionEpsilon) {
									//System.out.println(singleRule.charAt(k) + " " + firstMap);
									for (Character c : firstMap.get(singleRule.charAt(k) + "")) {
										if (!follow.contains(c) && c != 'e') {
											follow.add(c);
											change = true;
										}
									}
								}
							}
							boolean intersectionEpsilon2 = true;
							for (int k = j + 1; k < singleRule.length(); k++) {
								if (!firstMap.get(singleRule.charAt(k) + "").contains('e')) {
									intersectionEpsilon2 = false;
								}
							}
							if (intersectionEpsilon2) {
								for (Character c : followMap.get(split[0])) {
									if (!follow.contains(c)) {
										follow.add(c);
										change = true;
									}
								}
							}
							Collections.sort(follow);
							followMap.put(singleRule.charAt(j)+"" , follow);
						}
					}
				}

			}
		}
		String result = "";
		for(String variable : Variables){
			result += variable + "/";
			for(Character c : followMap.get(variable)){
				result += c;
			}
			result += ";";
		}
		// TODO Auto-generated method stub
		//System.out.println(result + followMap);
		return result.substring(0, result.length()-1);
	}

}
