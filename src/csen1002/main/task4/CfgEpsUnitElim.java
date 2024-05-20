package csen1002.main.task4;

import java.util.*;

/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

public class CfgEpsUnitElim {

	/**
	 * Constructs a Context Free Grammar
	 *
	 * @param cfg A formatted string representation of the CFG. The string
	 *             representation follows the one in the task description
	 */
	String variablesSemiColon;
	String Variables [];
	String terminalsSemiColon;
	String rules [];
	HashMap<String, List<String>> rulesMap = new HashMap<String,List<String>>();
	HashSet<String> replacedEpsilons = new HashSet<String>();
	HashSet<String> replacedUnits = new HashSet<String>();
	public CfgEpsUnitElim(String cfg) {
		// TODO Auto-generated constructor stub
		String [] split = cfg.split("#");
		variablesSemiColon = split[0];
		Variables = split[0].split(";");
		terminalsSemiColon = split[1];
		rules = split[2].split(";");
		populateRulesMap();
	}

	/**
	 * @return Returns a formatted string representation of the CFG. The string
	 *         representation follows the one in the task description
	 */
	private void populateRulesMap() {
		for(String rule : rules) {
			String[] split = rule.split("/");
			if(rulesMap.containsKey(split[0])) {
				List<String> oldRules = rulesMap.get(split[0]);
				String [] splitRules = split[1].split(",");
				oldRules.addAll(Arrays.asList(splitRules));
				rulesMap.put(split[0], oldRules);
			}
			else {
				List<String> newRules = new ArrayList<>();
				String [] splitRules = split[1].split(",");
				newRules.addAll(Arrays.asList(splitRules));
				rulesMap.put(split[0], newRules);
			}
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		int counter = 0;
		for(String var : Variables) {

			if(rulesMap.containsKey(var)) {
				List<String> rules = rulesMap.get(var);
				if(rules.isEmpty()){
					if(counter== Variables.length-1 && counter==0) {
						variablesSemiColon = variablesSemiColon.replace(var, "");
					}
					else if(counter== Variables.length-1 && counter!=0) {
						variablesSemiColon = variablesSemiColon.replace(";"+var, "");
					}
					else if (counter!=0) {
						variablesSemiColon = variablesSemiColon.replace(";"+var+";", "");
					}
					else {
						variablesSemiColon = variablesSemiColon.replace(var+";", "");
					}

					continue;
				}
				result += var + "/";
				for(String rule : rules) {
					result += rule + ",";
				}
				result = result.substring(0, result.length()-1);
			}
			result += ";";
			counter++;
		}
		return variablesSemiColon+"#"+ terminalsSemiColon+"#"+ result.substring(0, result.length()-1);
	}
	/**
	 * Eliminates Epsilon Rules from the grammar
	 */
	public void eliminateEpsilonRules() {
		// TODO Auto-generated method stub
		boolean changed=true;
		while(changed)	{    changed=false;
			for (String var : Variables) {
				if(rulesMap.containsKey(var)) {
					List<String> oldRules = rulesMap.get(var);
					if(oldRules.contains("e")) {
						oldRules.remove("e");
						rulesMap.put(var, oldRules);
						changed=true;
						replacedEpsilons.add(var);
						eliminateEpsilonRulesHelper(var);
					}
				}
			}}

	}
	private void eliminateEpsilonRulesHelper(String var) {
		for(String key : rulesMap.keySet()) {
			List<String> oldRules = rulesMap.get(key);
			for (int k=0;k<oldRules.size();k++) {
				String rule = oldRules.get(k);
				if (rule.contains(var)) {
					String[] split = rule.split("");
					for (int i=0; i<split.length; i++) {
						if(split[i].equals(var)) {
							String newRule = "";
							for (int j=0; j<split.length; j++) {
								if(j!=i) {
									newRule += split[j];
								}
							}
							if(newRule.equals("") && !replacedEpsilons.contains(key)) {

								if(!oldRules.contains("e")) {
									oldRules.add("e");
								}
							}
							else if(!oldRules.contains(newRule) && !newRule.equals("")) {
								oldRules.add(newRule);

							}
						}
					}
				}
			}
			Collections.sort(oldRules);
			rulesMap.put(key, oldRules);
		}
	}
	/**
	 * Eliminates Unit Rules from the grammar
	 */
	public void eliminateUnitRules() {
		// TODO Auto-generated method stub
		boolean changed=true;
		while(changed){
			changed = false;
			for (String var : Variables) {
				if (rulesMap.containsKey(var)) {
					List<String> oldRules = rulesMap.get(var);
					for (int i = 0; i < oldRules.size(); i++) {
						String rule = oldRules.get(i);
						if (rule.length() == 1 && Arrays.toString(Variables).contains(rule)) {
							replacedUnits.add(var + "/" + rule);
							oldRules.remove(rule);
							for (String newRule : rulesMap.get(rule)) {
								if (!oldRules.contains(newRule) && !replacedUnits.contains(var + "/" + newRule)) {
									oldRules.add(newRule);
									changed=true;
								}
							}
						}
					}
					Collections.sort(oldRules);
					rulesMap.put(var, oldRules);
				}
			}
		}
	}
}