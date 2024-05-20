package csen1002.main.task5;

import java.util.*;

/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

public class CfgLeftRecElim {

	/**
	 * Constructs a Context Free Grammar
	 *
	 * @param cfg A formatted string representation of the CFG. The string
	 * representation follows the one in the task description
	 */
	String variablesSemiColon;
	String Variables[];
	String terminalsSemiColon;
	String rules[];
	HashMap<String, List<String>> rulesMap = new HashMap<String, List<String>>();
	HashSet<String> finishedVars = new HashSet<String>();

	public CfgLeftRecElim(String cfg) {
		// TODO Auto-generated constructor stub
		String[] split = cfg.split("#");
		variablesSemiColon = split[0];
		Variables = split[0].split(";");
		terminalsSemiColon = split[1];
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
	 * @return Returns a formatted string representation of the CFG. The string
	 * representation follows the one in the task description
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		int counter = 0;
		for (String var : Variables) {

			if (rulesMap.containsKey(var)) {
				List<String> rules = rulesMap.get(var);
				if (rules.isEmpty()) {
					if (counter == Variables.length - 1 && counter == 0) {
						variablesSemiColon = variablesSemiColon.replace(var, "");
					} else if (counter == Variables.length - 1 && counter != 0) {
						variablesSemiColon = variablesSemiColon.replace(";" + var, "");
					} else if (counter != 0) {
						variablesSemiColon = variablesSemiColon.replace(";" + var + ";", "");
					} else {
						variablesSemiColon = variablesSemiColon.replace(var + ";", "");
					}

					continue;
				}
				result += var + "/";
				for (String rule : rules) {
					result += rule + ",";
				}
				result = result.substring(0, result.length() - 1);
			}
			result += ";";
			counter++;
		}
		return variablesSemiColon + "#" + terminalsSemiColon + "#" + result.substring(0, result.length() - 1);
	}

	private void eliminateImmediateLeftRecursion(String var) {
		List<String> rules = rulesMap.get(var);
		List<String> newRules = new ArrayList<>();
		boolean hasLeftRecursion = false;
		for (int i = 0; i < rules.size(); i++) {
			String rule = rules.get(i);
			if (rule.startsWith(var)) {
				hasLeftRecursion = true;
			}

		}

		if (hasLeftRecursion){
			for (int i = 0; i < rules.size(); i++) {
				String rule = rules.get(i);
				if (rule.startsWith(var)) {
					newRules.add(rule.substring(1) + var + "'");
					rules.remove(i);
					i--;

				} else {
					rules.set(i, rule + var + "'");
				}

			}
			newRules.add("e");
			variablesSemiColon += ";" + var + "'";
			Variables = variablesSemiColon.split(";");
			rulesMap.put(var + "'", newRules);
			rulesMap.put(var, rules);

		}

	}

	private void replacePreviousSeenVars(String currentVar) {
		List<String> rules = rulesMap.get(currentVar);
		for (int i = 0; i < rules.size(); i++) {
			String rule = rules.get(i);
			String firstElement = rule.substring(0, 1);
			if (finishedVars.contains(firstElement)) {
				List<String> finishedVarRules = rulesMap.get(firstElement);
				int j=i;
				for (String finishedVarRule : finishedVarRules) {
					rules.add(++j,finishedVarRule + rule.substring(1));

				}
				rules.remove(i);
				i--;
			}
		}
		rulesMap.put(currentVar, rules);
	}

	/**
	 * Eliminates Left Recursion from the grammar
	 */
	public void eliminateLeftRecursion() {
		// TODO Auto-generated method stub
		int n = Variables.length;
		for (int i = 0; i < n; i++) {
			String var = Variables[i];
			replacePreviousSeenVars(var);
			eliminateImmediateLeftRecursion(var);
			finishedVars.add(var);

		}


	}
}